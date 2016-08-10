import { Component, OnInit } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/Rx';

import { CHART_DIRECTIVES } from 'ng2-charts/ng2-charts';
import { TemperatureReading } from './temperatureReading';
import { TemperatureReadingLineChartService } from './temperatureReadingLineChart.service';
import { CustomDateStringPipe } from '../pipe/customDateString.pipe';

@Component({
  selector: 'temperatureReadingLineChart-detail',
  directives: [CHART_DIRECTIVES],
  styles: [`
    .chart {
      display: block;
    }
  `],
  template: `
    <base-chart
      class="chart"
      [datasets]="lineChartData"
      [options]="lineChartOptions"
      [colors]="lineChartColours"
      [chartType]="lineChartType">
    </base-chart>
  `,
  pipes: [CustomDateStringPipe]
})

export class TemperatureReadingLineChartComponent implements OnInit {
    private temperatureReadings:Array<TemperatureReading> = [];
    public temperatureReadingLineChartError:Boolean = true;

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

    private lineChartOptions:any = {
        responsive: true,
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
          backgroundColor: 'rgba(77,83,96,0.2)',
          borderColor: 'rgba(77,83,96,1)',
          pointBackgroundColor: 'rgba(77,83,96,1)',
          pointBorderColor: '#fff',
          pointHoverBackgroundColor: '#fff',
          pointHoverBorderColor: 'rgba(77,83,96,1)'
        }
      ];

    constructor(private _temperatureReadingLineChartService: TemperatureReadingLineChartService) { }

    ngOnInit() {
        this.getTemperatureReadingList();
        for (let temperatureReading of this.temperatureReadings) {
            console.error(temperatureReading.temperature);
        }

    }

    getTemperatureReadingList() {
        this.temperatureReadingLineChartError = false;
        this._temperatureReadingLineChartService.getTemperatureReadingList().subscribe(
            data => {this.temperatureReadings = data},
            err => {this.temperatureReadingLineChartError = true}
        );
    }
}