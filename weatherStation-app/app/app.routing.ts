import { RouterConfig } from '@angular/router';
import { RouterModule } from '@angular/router';

import { LastTemperatureReadingComponent } from './lastTemperatureReading/lastTemperatureReading.component';
import { TemperatureReadingLineChartComponent } from './temperatureReadingLineChart/temperatureReadingLineChart.component';
import { TemperatureReadingListComponent } from './temperatureReadingList/temperatureReadingList.component';

const appRoutes: RouterConfig = [
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

export const routing = RouterModule.forRoot(appRoutes);