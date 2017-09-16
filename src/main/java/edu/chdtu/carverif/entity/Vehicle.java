package edu.chdtu.carverif.entity;

import javax.persistence.*;

/**
 * Created by Metr_yumora on 06.09.2017.
 */
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String registrationNumber;

    @Column
    private Integer engineNumber;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private String technicalPassport;

    @ManyToOne
    private Client owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(Integer engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTechnicalPassport() {
        return technicalPassport;
    }

    public void setTechnicalPassport(String technicalPassport) {
        this.technicalPassport = technicalPassport;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Vehicle(String registrationNumber,
                   Integer engineNumber,
                   String model,
                   String color,
                   String technicalPassport,
                   Client owner) {
        this.registrationNumber = registrationNumber;
        this.engineNumber = engineNumber;
        this.model = model;
        this.color = color;
        this.technicalPassport = technicalPassport;
        this.owner = owner;
    }

    public Vehicle() {
    }


}
