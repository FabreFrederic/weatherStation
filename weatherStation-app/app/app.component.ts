import { Component } from 'angular2/core';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from 'angular2/router';

import { LastTemperatureReadingService } from './lastTemperatureReading/lastTemperatureReading.service';
import { TemperatureReadingListService } from './temperatureReadingList/temperatureReadingList.service';

import { LastTemperatureReadingComponent } from './lastTemperatureReading/lastTemperatureReading.component';
import { TemperatureReadingListComponent } from './temperatureReadingList/temperatureReadingList.component';

@Component({
  selector: 'my-app',
  template: `
    <h1>{{title}}</h1>
    <nav>
      <a [routerLink]="['LastTemperatureReading']">Current temperature</a>
      <a [routerLink]="['TemperatureReadingList']">Today temperature reading</a>
    </nav>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['app/app.component.css'],
  directives: [ROUTER_DIRECTIVES],
  providers: [
    ROUTER_PROVIDERS,
    LastTemperatureReadingService,
    TemperatureReadingListService
  ]
})

@RouteConfig([
  {
    path: '/lastTemperatureReading',
    name: 'LastTemperatureReading',
    component: LastTemperatureReadingComponent,
    useAsDefault: true
  },
  {
    path: '/temperatureReadingList',
    name: 'TemperatureReadingList',
    component: TemperatureReadingListComponent
  }
])
export class AppComponent {
  title = 'Weather Station';
}