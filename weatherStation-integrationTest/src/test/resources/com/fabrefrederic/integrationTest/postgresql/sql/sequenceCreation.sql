-- Sequence: weather_station_sequence
 CREATE SEQUENCE weather_station_sequence
  INCREMENT 1
  MINVALUE 1
  START 1
  CACHE 1;

ALTER TABLE weather_station_sequence
 OWNER TO docker;
