import { Component, OnInit } from 'angular2/core';
import { TemperatureReading } from './temperatureReading';
import { LastTemperatureReadingService } from './lastTemperatureReading.service';
import 'rxjs/Rx';

@Component({
    selector: 'lastTemperatureReading-detail',
    templateUrl: 'app/lastTemperatureReading/lastTemperatureReading.component.html'
})

export class LastTemperatureReadingComponent implements OnInit {
    public lastTemperatureReading:TemperatureReading;
    public lastTemperatureReadingError:Boolean = true;

    constructor(private _lastTemperatureReadingService: LastTemperatureReadingService) { }

    ngOnInit() {
        this.getLastTemperatureReading();
    }

    getLastTemperatureReading() {
        this.lastTemperatureReadingError = false;
        this._lastTemperatureReadingService.getLastTemperatureReading().subscribe(
            data => {this.lastTemperatureReading = data},
            err => {this.lastTemperatureReadingError = true}
        );
    }

}