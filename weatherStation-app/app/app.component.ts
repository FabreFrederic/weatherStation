import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  template: `
    <h1>{{title}}</h1>
    <nav>
        <a routerLink="/lastTemperatureReading" routerLinkActive="active">Current temperature</a>
        <a routerLink="/temperatureReadingList" routerLinkActive="active">Today temperature reading</a>
        <a routerLink="/temperatureReadingLineChart" routerLinkActive="active">Today temperature reading line chart</a>
    </nav>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['app/app.component.css'],
})

export class AppComponent {
  title = 'Weather Station';
}