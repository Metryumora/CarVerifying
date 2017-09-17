package edu.chdtu.carverif.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Metr_yumora on 06.09.2017.
 */
@Entity
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Column
    private String result;

    @Column
    private String remarks;

    @ManyToOne
    private User user;

    @ManyToOne(targetEntity = Vehicle.class)
    private Vehicle vehicle;

    public Verification(String result, User user, Vehicle vehicle, String remarks) {
        this.dateTime = new Date();
        this.result = result;
        this.vehicle = vehicle;
        this.user = user;
    }

    public Verification() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
