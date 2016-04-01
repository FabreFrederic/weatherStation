/** To avoid error :
* error TS2304: Cannot find name 'Promise'
* https://github.com/angular/angular/blob/master/CHANGELOG.md#200-beta6-2016-02-11
* */
/// <reference path="../node_modules/angular2/typings/browser.d.ts" />

import {bootstrap} from 'angular2/platform/browser';
import {HTTP_PROVIDERS, Http} from 'angular2/http';
import {AppComponent} from './app.component';

bootstrap(AppComponent, [HTTP_PROVIDERS]);