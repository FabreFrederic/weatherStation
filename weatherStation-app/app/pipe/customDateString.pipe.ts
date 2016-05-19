import {Pipe, PipeTransform} from 'angular2/core';
import {DatePipe} from 'angular2/common';

@Pipe({ name: 'customDateStringPipe' })
export class CustomDateStringPipe implements PipeTransform {
    transform(value: string, pattern: string): string {
        var parsedDate = Date.parse(value);
        if (isNaN(parsedDate)) {
            return "";
        }
        else {
            return new DatePipe().transform(new Date(parsedDate), pattern);
        }
    }
}
