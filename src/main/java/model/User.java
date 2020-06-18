package model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//@Scope("session")
@Entity //Класс представляет объект, который нужно долговременно хранить. поля класса имеют отображение в БД
@Table(name = "users", schema = "seriesdiscuss")
public class User implements Serializable {



    @Id
    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "password", nullable = true, length = 255)
    private String password;

    @Column(name = "forename", nullable = true, length = 255)
    private String forename;

    @Column(name = "surname", nullable = true, length = 255)
    private String surname;

    @Column(name = "rate_user", nullable = true)
    private Long rateUser = 0L;

    @Column(name = "birthdate", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @Column(name = "enabled")
    private boolean enabled = true            ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Authorities> authorities = new HashSet<>();

    public User(String username, String password, String forename, String surname, Long rateUser, LocalDate birthdate, boolean enabled, Set<Authorities> authorities) {
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.rateUser = rateUser;
        this.birthdate = birthdate;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =                // passwordEncoder.encode(
                        password;}

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getRateUser() {
        return rateUser;
    }

    public void setRateUser(Long rateUser) {
        this.rateUser = rateUser;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", rateUser=" + rateUser +
                ", birthdate=" + birthdate +
                ", enabled=" + enabled +
                ", authorities=" + authorities +
                '}';
    }
}
