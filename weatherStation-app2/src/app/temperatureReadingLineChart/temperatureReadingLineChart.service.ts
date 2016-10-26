import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { DateUtil } from '../util/dateUtil';
import { TemperatureReading } from './temperatureReading';

@Injectable()
export class TemperatureReadingLineChartService {

    public http: Http;
    private endpoint: string =
        'http://localhost:8081/weatherStation-webapp/rest/temperatureReading/getTemperatureReadingByDay/';

    private date:Date = new Date();

    constructor(http: Http) {
        this.http = http;
    }

    getTemperatureReadingListFromServer() {
        return this.http.get(this.endpoint + DateUtil.format(this.date, 'YYYYMMDD')).map((res:Response) => res.json());
    }
}
