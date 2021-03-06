package edu.chdtu.carverif.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Metr_yumora on 06.09.2017.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String passport;

    @Column
    private String address;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Client(String name, String passport, String address, Date birthDate) {
        this.name = name;
        this.passport = passport;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Client() {
    }
}
