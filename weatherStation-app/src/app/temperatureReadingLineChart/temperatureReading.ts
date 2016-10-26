export class TemperatureReading {
    public date:Date;
    public temperature:number;

    constructor(date:Date, temperature:number) {
        this.date = date;
        this.temperature = temperature;
    }

    public getDate() {
        return this.date;
    }

    public getTemperature() {
        return this.temperature;
    }
}