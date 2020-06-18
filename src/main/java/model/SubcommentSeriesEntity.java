package model;

import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
@Table(name = "subcomment_series", schema = "seriesdiscuss", catalog = "")
public class SubcommentSeriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcomment_series", nullable = false)
    private long idSubcommentSeries;

    @Column(name = "content_subcomment_series", nullable = true, length = 2040)
    private String contentSubcommentSeries;

    @Column(name = "likes_quantity_subcomment_series", nullable = true)
    private long likesQuantitySubcommentSeries;

    @ManyToOne
    @JoinColumn(name = "username_user_user", referencedColumnName = "username", nullable = false)
    private User userByUsernameUserUser;


    public long getIdSubcommentSeries() {
        return idSubcommentSeries;
    }

    public void setIdSubcommentSeries(long idSubcommentSeries) {
        this.idSubcommentSeries = idSubcommentSeries;
    }

    public String getContentSubcommentSeries() {
        return contentSubcommentSeries;
    }

    public void setContentSubcommentSeries(String contentSubcommentSeries) {
        this.contentSubcommentSeries = contentSubcommentSeries;}

    public Long getLikesQuantitySubcommentSeries() {
        return likesQuantitySubcommentSeries;
    }

    public void setLikesQuantitySubcommentSeries(Long likesQuantitySubcommentSeries) {
        this.likesQuantitySubcommentSeries = likesQuantitySubcommentSeries;
    }

    public SubcommentSeriesEntity(){}


    public SubcommentSeriesEntity(String contentSubcommentSeries, long likesQuantitySubcommentSeries, User userByUsernameUserUser) {
        this.contentSubcommentSeries = contentSubcommentSeries;
        this.likesQuantitySubcommentSeries = likesQuantitySubcommentSeries;
        this.userByUsernameUserUser = userByUsernameUserUser;
    }

    public User getUserByUsernameUserUser() {
        return userByUsernameUserUser;
    }

    public void setUserByUsernameUserUser(User userByUsernameUserUser) {
        this.userByUsernameUserUser = userByUsernameUserUser;
    }
}
