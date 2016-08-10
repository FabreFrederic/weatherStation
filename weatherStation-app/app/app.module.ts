import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule, XHRBackend } from '@angular/http';

import { AppComponent } from './app.component';
import { routing } from './app.routing';

import { LastTemperatureReadingComponent } from './lastTemperatureReading/lastTemperatureReading.component';
import { TemperatureReadingLineChartComponent }   from './temperatureReadingLineChart/temperatureReadingLineChart.component';
import { TemperatureReadingListComponent }  from './temperatureReadingList/temperatureReadingList.component';

import { LastTemperatureReadingService }  from './lastTemperatureReading/lastTemperatureReading.service';
import { TemperatureReadingLineChartService }  from './temperatureReadingLineChart/temperatureReadingLineChart.service';
import { TemperatureReadingListService }  from './temperatureReadingList/temperatureReadingList.service';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    routing,
    HttpModule
  ],
  declarations: [
    AppComponent,
    LastTemperatureReadingComponent,
    TemperatureReadingLineChartComponent,
    TemperatureReadingListComponent
  ],
  providers: [
    LastTemperatureReadingService,
    TemperatureReadingLineChartService,
    TemperatureReadingListService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}