create table temperature_reading (
    temperature_reading_id integer not null,
    temperature_reading_temperature double precision,
    temperature_reading_date timestamp without time zone,
    temperature_reading_sensor_id integer,
    primary key (temperature_reading_id)
);

ALTER TABLE temperature_reading
ALTER COLUMN temperature_reading_id
SET DEFAULT nextval('weather_station_sequence');
ALTER TABLE temperature_reading OWNER TO docker;

create table sensor (
    sensor_id integer not null,
    sensor_description varchar(255) unique,
    sensor_creation_date timestamp without time zone,
    sensor_outdoor boolean,
    primary key (sensor_id)
);
ALTER TABLE sensor
ALTER COLUMN sensor_id
SET DEFAULT nextval('weather_station_sequence');
ALTER TABLE sensor OWNER TO docker;

