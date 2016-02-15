package com.fabrefrederic.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "temperature_reading")
public class TemperatureReading implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Id */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_station_sequence")
    @SequenceGenerator(name = "weather_station_sequence", sequenceName = "weather_station_sequence", allocationSize = 1)
    @Column(name = "temperature_reading_id")
    private int id;

    /** Temperature */
    @Column(name = "temperature_reading_temperature")
    private Double temperature;

    /** Date */
    @Column(name = "temperature_reading_date")
    private Date date;

    /** Sensor */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "temperature_reading_sensor_id", unique = false, nullable = true)
    private Sensor sensor;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the sensor
     */
    public Sensor getSensor() {
        return sensor;
    }

    /**
     * @param sensor the sensor to set
     */
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

}
