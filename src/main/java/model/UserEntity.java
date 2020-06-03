package model;

import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Scope("session")
@Entity //Класс представляет объект, который нужно долговременно хранить. поля класса имеют отображение в БД
@Table(name = "user", schema = "seriesdiscuss")
public class UserEntity implements Serializable {

 //   private static final long serialVersionUID = 1L;


    @Column(name = "forename", nullable = true, length = 255)
    private String forename;

    @Column(name = "surname", nullable = true, length = 255)
    private String surname;

    @Id
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = true, length = 255)
    private String password;

    @Column(name = "rate_user", nullable = true)
    private Long rateUser = 0L;

    @Column(name = "birthdate", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<RolesEntity> roles = new HashSet<>();


    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return (Collection<? extends GrantedAuthority>) getRoles();
//    }

//    @OneToMany
//    @JoinColumn(name = "email_user", referencedColumnName = "email")
//    private Set<RolesEntity> setUserRole = new HashSet<RolesEntity>(0);;
//
//    public Set<RolesEntity> getUserRole() {
//        return userRolesEntity.getUserRole(email);
//    }
//
//    public void setUserRole(Set<RolesEntity> userRole) {
//        this.userRole = userRole;
//    }


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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesEntity> roles) {
        this.roles = roles;
    }

    public UserEntity(){}

    public UserEntity(String forename, String surname, String email, String password, Long rateUser, LocalDate birthdate, boolean enabled, Set<RolesEntity> roles) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rateUser = rateUser;
        this.birthdate = birthdate;
        this.enabled = enabled;
        this.roles = roles;
    }

    public UserEntity(String forename, String surname, String email, String password, Long rateUser, LocalDate birthdate, boolean enabled) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rateUser = rateUser;
        this.birthdate = birthdate;
        this.enabled = enabled;
    }

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserEntity(String forename, String surname, String email, String password, LocalDate birthdate) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public UserEntity(String forename, String surname, String email, String password, Long rateUser, LocalDate birthdate) {
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
        return enabled == that.enabled &&
                Objects.equals(forename, that.forename) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(rateUser, that.rateUser) &&
                Objects.equals(birthdate, that.birthdate) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forename, surname, email, password, rateUser, birthdate, enabled, roles);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rateUser=" + rateUser +
                ", birthdate=" + birthdate +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }


    //    public UserDetails toCurrentUserDetails() {
//        return CurrentUserDetails.create(this);
//    }


}
