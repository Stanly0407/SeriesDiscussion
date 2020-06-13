package model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "authorities", schema = "seriesdiscuss", catalog = "")
@Data
@ToString(exclude = "user")
public class Authorities {
    @Id
    @Column(name = "authority", nullable = false, length = 45)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Authorities() {}

    public Authorities(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
