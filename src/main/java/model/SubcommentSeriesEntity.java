package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subcomment_series", schema = "seriesdiscuss", catalog = "")
public class SubcommentSeriesEntity {
    private long idSubcommentSeries;
    private String contentSubcommentSeries;
    private long likesQuantitySubcommentSeries;
    private UserEntity userByIdUserUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcomment_series", nullable = false)
    public long getIdSubcommentSeries() {
        return idSubcommentSeries;
    }

    public void setIdSubcommentSeries(long idSubcommentSeries) {
        this.idSubcommentSeries = idSubcommentSeries;
    }

    @Basic
    @Column(name = "content_subcomment_series", nullable = true, length = 2040)
    public String getContentSubcommentSeries() {
        return contentSubcommentSeries;
    }

    public void setContentSubcommentSeries(String contentSubcommentSeries) {
        this.contentSubcommentSeries = contentSubcommentSeries;
    }

    @Basic
    @Column(name = "likes_quantity_subcomment_series", nullable = true)
    public Long getLikesQuantitySubcommentSeries() {
        return likesQuantitySubcommentSeries;
    }

    public void setLikesQuantitySubcommentSeries(Long likesQuantitySubcommentSeries) {
        this.likesQuantitySubcommentSeries = likesQuantitySubcommentSeries;
    }

    public SubcommentSeriesEntity(){}

    public SubcommentSeriesEntity(long idSubcommentSeries, String contentSubcommentSeries, Long likesQuantitySubcommentSeries, model.UserEntity userByIdUserUser) {
        this.idSubcommentSeries = idSubcommentSeries;
        this.contentSubcommentSeries = contentSubcommentSeries;
        this.likesQuantitySubcommentSeries = likesQuantitySubcommentSeries;
        this.userByIdUserUser = userByIdUserUser;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubcommentSeriesEntity that = (SubcommentSeriesEntity) o;
        return idSubcommentSeries == that.idSubcommentSeries &&
                likesQuantitySubcommentSeries == that.likesQuantitySubcommentSeries &&
                Objects.equals(contentSubcommentSeries, that.contentSubcommentSeries) &&
                Objects.equals(userByIdUserUser, that.userByIdUserUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubcommentSeries, contentSubcommentSeries, likesQuantitySubcommentSeries, userByIdUserUser);
    }

    @ManyToOne
    @JoinColumn(name = "id_user_user", referencedColumnName = "id_user")
    public model.UserEntity getUserByIdUserUser() {
        return userByIdUserUser;
    }

    public void setUserByIdUserUser(model.UserEntity userByIdUserUser) {
        this.userByIdUserUser = userByIdUserUser;
    }

    @Override
    public String toString() {
        return "model.SubcommentSeriesEntity{" +
                "idSubcommentSeries=" + idSubcommentSeries +
                ", contentSubcommentSeries='" + contentSubcommentSeries + '\'' +
                ", likesQuantitySubcommentSeries=" + likesQuantitySubcommentSeries +
                ", userByIdUserUser=" + userByIdUserUser +
                '}';
    }
}
