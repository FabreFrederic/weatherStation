#!/bin/sh

# One day of temperature readings
minutesNumber=250
temperature=15

for i in $(seq 5 $minutesNumber)
do
    echo "number : $minutesNumber"
    newDate=$(date '+%Y-%m-%dT%H:%M:%S.000' -d "$i minutes")
    add="0.00"$(shuf -i 1-9 -n 1)
    
    if [ "$i" -lt 125 ]; 
    then
	temperature=$(echo $temperature + $add | bc)
    else
     	temperature=$(echo $temperature - $add | bc)
    fi
    echo $temperature

    data="{\"temperatureReading\":{\"date\":\"$newDate\",\"temperature\":\"$temperature\",\"sensorId\":1}}"

    #echo $data
    curl -i -X POST -H "Content-Type:application/json" http://localhost:8081/weatherStation-webapp/rest/temperatureReading/saveTemperatureReading -d "$data"
done

