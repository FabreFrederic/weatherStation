import { Routes, RouterModule } from '@angular/router';

import { LastTemperatureReadingComponent } from './lastTemperatureReading/lastTemperatureReading.component';
import { TemperatureReadingLineChartComponent } from './temperatureReadingLineChart/temperatureReadingLineChart.component';
import { TemperatureReadingListComponent } from './temperatureReadingList/temperatureReadingList.component';

const routes: Routes = [
    {
        path: '',
        redirectTo: '/lastTemperatureReading',
        pathMatch: 'full'
    },
    {
        path: 'lastTemperatureReading',
        component: LastTemperatureReadingComponent
    },
    {
        path: 'temperatureReadingLineChart',
        component: TemperatureReadingLineChartComponent
    },
    {
        path: 'temperatureReadingList',
        component: TemperatureReadingListComponent
    }
];

export const routing = RouterModule.forRoot(routes);