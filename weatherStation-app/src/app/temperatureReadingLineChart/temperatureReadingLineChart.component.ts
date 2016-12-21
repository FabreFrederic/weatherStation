import { platformBrowserDynamic }  from '@angular/platform-browser-dynamic';
import { NgModule, Component }     from '@angular/core';
import { Jsonp, JsonpModule }      from '@angular/http';
import { Http, Response }          from '@angular/http';
import { BrowserModule }           from '@angular/platform-browser';
import { ChartModule }             from 'angular2-highcharts';

import { TemperatureReading }                 from './temperatureReading';
import { TemperatureReadingLineChartService } from './temperatureReadingLineChart.service';

@Component({
    selector: 'my-app',
    styles: [`
      chart {
        display: block;
      }
    `],
    templateUrl: './temperatureReadingLineChart.component.html'
})

export class TemperatureReadingLineChartComponent {

    options: Object;
    private temperatureReadings: Array<TemperatureReading> = [];
    public temperatureReadingLineChartError: Boolean = true;

    constructor(private temperatureReadingLineChartService: TemperatureReadingLineChartService) {
        console.log('Constructor begin'); 

        let formattedData: Array<any> = [];
        temperatureReadingLineChartService.getTemperatureReadingListFromServer().subscribe(
            (data) => {
                data.forEach(
                    (dataset: any) => {
                        // Highcharts prefers dates in milliseconds
                        let newDate = +new Date(dataset.temperatureReading.date)
                        formattedData.push({
                            x: newDate,
                            y: dataset.temperatureReading.temperature
                        });
                    }
                );

                console.log('formattedData : ' + formattedData);

                this.options = {
                    chart: {
                        type: 'spline',
                        marginTop: 10
                      },
                    xAxis: {
                        type : 'datetime',
                        title : {
                          text : ''
                        },
                        tickInterval : 300000
                      },
                      yAxis : {
                        title : {
                          text : ''
                        },
                        min: 0
                    },
                    rangeSelector: {
                        buttons: [{
                            type: 'min',
                            count: 1,
                            text: '1m'
                        }, {
                            type: 'hour',
                            count: 1,
                            text: '1h'
                        }, {
                            type: 'all',
                            count: 1,
                            text: 'All'
                        }],
                        selected: 1,
                        inputEnabled: true
                    },                    
                    series : [{
                        name : 'temperature',
                        data: formattedData,
                        type: 'area',
                        gapSize: 1,                   
                        tooltip: {
                            valueDecimals: 2
                        }
                    }]
                };
            }
        );
    }
}
