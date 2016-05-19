import { Component, OnInit } from 'angular2/core';
import { TemperatureReading } from './temperatureReading';
import { TemperatureReadingListService } from './temperatureReadingList.service';
import { CustomDateStringPipe } from '../pipe/customDateString.pipe';
import 'rxjs/Rx';

@Component({
    selector: 'temperatureReadingList-detail',
    templateUrl: 'app/temperatureReadingList/temperatureReadingList.component.html',
    pipes: [CustomDateStringPipe]
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