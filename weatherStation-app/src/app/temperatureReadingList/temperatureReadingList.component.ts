import { Component, OnInit } from '@angular/core';
import { TemperatureReading } from './temperatureReading';
import { TemperatureReadingListService } from './temperatureReadingList.service';
import {Http, Response} from '@angular/http';
import 'rxjs/Rx';

@Component({
    selector: 'temperatureReadingList-detail',
    templateUrl: './temperatureReadingList.component.html'
})

export class TemperatureReadingListComponent implements OnInit {
    temperatureReadings: TemperatureReading[] = [];
    public temperatureReadingListError:Boolean = true;

    constructor(private _temperatureReadingListService: TemperatureReadingListService) { }

    ngOnInit() {
        this.getTemperatureReadingList();
    }

    getTemperatureReadingList() {
        this.temperatureReadingListError = false;
        this._temperatureReadingListService.getTemperatureReadingList().subscribe(
            data => {this.temperatureReadings = data},
            err => {this.temperatureReadingListError = true}
        );
    }

}