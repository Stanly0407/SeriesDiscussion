package model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "user", schema = "seriesdiscuss")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private long idUser;

    @Basic
    @Column(name = "forename", nullable = true, length = 255)
    private String forename;

    @Basic
    @Column(name = "surname", nullable = true, length = 255)
    private String surname;

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;

    @Basic
    @Column(name = "rate_user", nullable = true)
    private long rateUser = 0;

    @Basic
    @Column(name = "birthdate", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserEntity(){}

    public UserEntity(long idUser, String forename, String surname, String email, String password, Long rateUser, LocalDate birthdate) {
        this.idUser = idUser;
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rateUser = rateUser;
        this.birthdate = birthdate;
    }

    public UserEntity(String forename, String surname, String email, String password, LocalDate birthdate) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public UserEntity(String forename, String surname, String email, String password, long rateUser, LocalDate birthdate) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rateUser = rateUser;
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser &&
                rateUser == that.rateUser &&
                Objects.equals(forename, that.forename) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, forename, surname, email, password, rateUser, birthdate);
    }

    @Override
    public String toString() {
        return "model.UserEntity{" +
                "idUser=" + idUser +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rateUser=" + rateUser +
                ", birthdate=" + birthdate +
                '}';
    }
}
