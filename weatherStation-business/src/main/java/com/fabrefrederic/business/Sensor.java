package com.fabrefrederic.business;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Id */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_station_sequence")
    @SequenceGenerator(name = "weather_station_sequence", sequenceName = "weather_station_sequence", allocationSize = 1)
    @Column(name = "sensor_id")
    private int id;

    /** Temperature */
    @Column(name = "sensor_description")
    private String description;

    /** Date */
    @Column(name = "sensor_creation_date")
    private Date creationDate;

    /** Is the sensor outdoor */
    @Column(name = "sensor_outdoor")
    private boolean outdoor;

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the outdoor
     */
    public boolean isOutdoor() {
        return outdoor;
    }

    /**
     * @param outdoor the outdoor to set
     */
    public void setOutdoor(boolean outdoor) {
        this.outdoor = outdoor;
    }

}
