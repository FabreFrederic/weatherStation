import { TEMPERATURE } from './mock-lastTemperatureReading';
import { Injectable } from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class LastTemperatureReadingService {
    public http:Http;
    private endpoint:string = 'http://localhost:8081/weatherStation-webapp/rest/temperatureReading/getTheLastTemperatureReading';

    constructor(http: Http) {
        this.http=http;
    }

    getLastTemperatureReading() {
        return this.http.get(this.endpoint).map((res:Response) => res.json());
    }

}