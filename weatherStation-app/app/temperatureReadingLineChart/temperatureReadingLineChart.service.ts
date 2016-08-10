import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import { DateUtil } from '../util/dateUtil';

@Injectable()
export class TemperatureReadingLineChartService {
    public http:Http;
    private endpoint:string =
        'http://localhost:8081/weatherStation-webapp/rest/temperatureReading/getTemperatureReadingByDay/';

    // TODO : To test, this line must be deleted
    private date:Date = new Date('2015/10/22');
    //private date:Date = new Date();

    constructor(http: Http) {
        this.http=http;
    }

    getTemperatureReadingList() {
        return this.http.get(this.endpoint + DateUtil.format(this.date, 'YYYYMMDD')).map((res:Response) => res.json());
    }
}
