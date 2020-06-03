package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
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
    @JoinColumn(name = "email_user_user", referencedColumnName = "email", nullable = false)
    private UserEntity userByEmailUserUser;


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

    public SubcommentSeriesEntity(String contentSubcommentSeries, long likesQuantitySubcommentSeries, UserEntity userByEmailUserUser) {
        this.contentSubcommentSeries = contentSubcommentSeries;
        this.likesQuantitySubcommentSeries = likesQuantitySubcommentSeries;
        this.userByEmailUserUser = userByEmailUserUser;
    }


    public UserEntity getUserByEmailUserUser() {
        return userByEmailUserUser;
    }

    public void setUserByEmailUserUser(model.UserEntity userByEmailUserUser) {
        this.userByEmailUserUser = userByEmailUserUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubcommentSeriesEntity that = (SubcommentSeriesEntity) o;
        return idSubcommentSeries == that.idSubcommentSeries &&
                likesQuantitySubcommentSeries == that.likesQuantitySubcommentSeries &&
                Objects.equals(contentSubcommentSeries, that.contentSubcommentSeries) &&
                Objects.equals(userByEmailUserUser, that.userByEmailUserUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubcommentSeries, contentSubcommentSeries, likesQuantitySubcommentSeries, userByEmailUserUser);
    }

    @Override
    public String toString() {
        return "SubcommentSeriesEntity{" +
                "idSubcommentSeries=" + idSubcommentSeries +
                ", contentSubcommentSeries='" + contentSubcommentSeries + '\'' +
                ", likesQuantitySubcommentSeries=" + likesQuantitySubcommentSeries +
                ", userByEmailUserUser=" + userByEmailUserUser +
                '}';
    }
}
