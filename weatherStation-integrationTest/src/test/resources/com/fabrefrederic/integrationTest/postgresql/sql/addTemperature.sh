#!/bin/sh

# One day of temperature readings
minutesNumber=1440
for i in $(seq 1 $minutesNumber)
do
    echo "number : $minutesNumber"
    newDate=$(date '+%Y-%m-%dT%H:%M:%S.000' -d "$i minutes")
    newTemperature=$(shuf -i 17-25 -n 1)
    data="{\"temperatureReading\":{\"date\":\"$newDate\",\"temperature\":\"$newTemperature\",\"sensorId\":1}}"

    echo $data
    curl -i -X POST -H "Content-Type:application/json" http://localhost:8081/weatherStation-webapp/rest/temperatureReading/saveTemperatureReading -d "$data"
done