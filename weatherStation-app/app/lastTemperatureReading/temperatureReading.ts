export class TemperatureReading {
    private date:Date;
    private temperature:number;

    constructor(date:Date, temperature:number) {
        this.date = date;
        this.temperature = temperature;
    }

    getDate() {
        return this.date;
    }

    getTemperature() {
        return this.temperature;
    }
}