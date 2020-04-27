package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "user", schema = "seriesdiscuss", catalog = "")
public class UserEntity implements Serializable {
    private long idUser;
    private String forename;
    private String surname;
    private String email;
    private String password;
    private long rateUser;
    private LocalDate birthdate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "forename", nullable = true, length = 255)
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 255)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "rate_user", nullable = true)
    public Long getRateUser() {
        return rateUser;
    }

    public void setRateUser(Long rateUser) {
        this.rateUser = rateUser;
    }

    @Basic
    @Column(name = "birthdate", nullable = true)
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
