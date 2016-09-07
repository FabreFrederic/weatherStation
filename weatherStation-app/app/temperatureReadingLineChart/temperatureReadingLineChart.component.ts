import { Component, OnInit, ViewChild } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/Rx';

import { CHART_DIRECTIVES } from 'ng2-charts/ng2-charts';
import { TemperatureReading } from './temperatureReading';
import { TemperatureReadingLineChartService } from './temperatureReadingLineChart.service';

@Component({
    selector: 'temperatureReadingLineChart-detail',
    directives: [CHART_DIRECTIVES],
    styles: [`
        .chart {
            display: block;
        }
    `],
    templateUrl: 'app/temperatureReadingLineChart/temperatureReadingLineChart.component.html'
})

export class TemperatureReadingLineChartComponent implements OnInit {
    private temperatureReadings:Array<TemperatureReading> = [];
    public temperatureReadingLineChartError:Boolean = true;
    private lineChartData:Array<any> = [{ data: [], label: [] }];

/**
    public lineChartData:Array<any> = [
        {
            data: [
                {
                    x: '00:00',
                    y: 15
                },
                {
                    x: '00:15',
                    y: 20
                },
                {
                    x: '00:30',
                    y: 21
                },
                {
                    x: '00:45',
                    y: 21
                },
                {
                    x: '01:00',
                    y: 22
                },
                {
                    x: '01:15',
                    y: 23
                },
                {
                    x: '01:30',
                    y: 22
                },
                {
                    x: '01:45',
                    y: 21
                },
                {
                    x: '02:00',
                    y: 18
                },
                {
                    x: '02:15',
                    y: 16
                }
            ],
            fill: true,
            label: 'Temperature'
        }
    ];
**/

    private lineChartOptions:any = {
        maintainAspectRatio: true,
        scales: {
            xAxes: [{
                type: "time",
                time: {
                    format: "HH:mm",
                    unit: 'hour',
                    displayFormats: {
                        'minute': 'HH:mm',
                        'hour': 'HH:mm',
                    },
                    tooltipFormat: 'HH:mm'
                }
            }],
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    };

    private lineChartType:string = 'line';

    private lineChartColours:Array<any> = [
        {
            fillColor: "rgba(151,187,205,0.2)",
            strokeColor: "rgba(151,187,205,1)",
            pointColor: "rgba(151,187,205,1)",
            pointStrokeColor: "#fff",
            pointHighlightFill: "#fff",
            pointHighlightStroke: "rgba(151,187,205,1)"
        }
    ];

    constructor(private _temperatureReadingLineChartService: TemperatureReadingLineChartService) { }

     ngOnInit() {
        this.getTemperatureReadingList();
    }

    getTemperatureReadingList() {
        this.temperatureReadingLineChartError = false;

        this._temperatureReadingLineChartService.getTemperatureReadingList().subscribe(
            (data) => {
                this.lineChartData = [];
                let dataOnly:Array<any> = [];
                data.forEach(
                    (dataset:any, index:any) => {
                        let tempDate:Date;
                        let newDate:Date = new Date(dataset.temperatureReading.date);

                        dataOnly.push({
                            x: newDate.getHours() + ":" + newDate.getMinutes(),
                            y: dataset.temperatureReading.temperature
                        });
                    }
                );
                this.lineChartData.push({
                    data: dataOnly,
                    fill: true,
                    label: 'Temperature'
                });
            }
        );
    }
}