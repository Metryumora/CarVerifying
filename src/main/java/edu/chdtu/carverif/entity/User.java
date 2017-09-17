package edu.chdtu.carverif.entity;

import javax.persistence.*;

/**
 * Created by Metr_yumora on 01.05.2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String login;

    @Column
    private String name;

    @Column
    private String hash;

    @Column
    private String position;

    @Column
    private String rank;

    public User() {
    }

    public User(String name, String login, String pass, String position, String rank) {
        this.name = name;
        this.login = login;
        this.position = position;
        this.rank = rank;
        try {
            this.hash = PasswordStorage.createHash(pass);
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        }
    }

    public Boolean verifyPassword(String password) {
        try {
            return PasswordStorage.verifyPassword(password, this.getHash());
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        } catch (PasswordStorage.InvalidHashException hashE) {
            hashE.printStackTrace();
        }
        return false;
    }

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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return getName();
    }
}
