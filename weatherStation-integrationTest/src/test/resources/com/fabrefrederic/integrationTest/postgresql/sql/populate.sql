insert into temperature_reading (
temperature_reading_date, 
temperature_reading_temperature,
temperature_reading_sensor_id)
values('2015-10-22 08:35:44.695+02', 15.5, 1);
   
insert into temperature_reading (
temperature_reading_date, 
temperature_reading_temperature,
temperature_reading_sensor_id)
values('2015-10-20 00:35:44.695+02', 7, 1);
 
insert into sensor (
sensor_id,
sensor_description,
sensor_creation_date,
sensor_outdoor)
values (1, 'The outdoor sensor', now(), true);
