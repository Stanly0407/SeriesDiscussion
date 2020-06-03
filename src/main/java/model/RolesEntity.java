package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "seriesdiscuss", catalog = "")
public class RolesEntity {
    @Id
    @Column(name = "role", nullable = false, length = 45)
    private String role;

    @ManyToOne
    @JoinColumn(name = "email")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RolesEntity() {}

    public RolesEntity(String role, UserEntity user) {
        this.role = role;
        this.user = user;
    }

    public RolesEntity(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntity that = (RolesEntity) o;
        return Objects.equals(role, that.role) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, user);
    }

    @Override
    public String toString() {
        return "RolesEntity{" +
                "role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}
