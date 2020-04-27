package model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subcomment_review", schema = "seriesdiscuss", catalog = "")
public class SubcommentReviewEntity {
    private long idSubcommentReview;
    private String contentSubcommentReview;
    private long likesQuantitySubcommentReview;
    private UserEntity userByIdUserUserUs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcomment_review", nullable = false)
    public long getIdSubcommentReview() {
        return idSubcommentReview;
    }

    public void setIdSubcommentReview(long idSubcommentReview) {
        this.idSubcommentReview = idSubcommentReview;
    }

    @Basic
    @Column(name = "content_subcomment_review", nullable = true, length = 2040)
    public String getContentSubcommentReview() {
        return contentSubcommentReview;
    }

    public void setContentSubcommentReview(String contentSubcommentReview) {
        this.contentSubcommentReview = contentSubcommentReview;
    }

    @Basic
    @Column(name = "likes_quantity_subcomment_review", nullable = true)
    public Long getLikesQuantitySubcommentReview() {
        return likesQuantitySubcommentReview;
    }

    public void setLikesQuantitySubcommentReview(Long likesQuantitySubcommentReview) {
        this.likesQuantitySubcommentReview = likesQuantitySubcommentReview;
    }

    public SubcommentReviewEntity(){}

    public SubcommentReviewEntity(long idSubcommentReview, String contentSubcommentReview, Long likesQuantitySubcommentReview, model.UserEntity userByIdUserUserUs) {
        this.idSubcommentReview = idSubcommentReview;
        this.contentSubcommentReview = contentSubcommentReview;
        this.likesQuantitySubcommentReview = likesQuantitySubcommentReview;
        this.userByIdUserUserUs = userByIdUserUserUs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubcommentReviewEntity that = (SubcommentReviewEntity) o;
        return idSubcommentReview == that.idSubcommentReview &&
                likesQuantitySubcommentReview == that.likesQuantitySubcommentReview &&
                Objects.equals(contentSubcommentReview, that.contentSubcommentReview) &&
                Objects.equals(userByIdUserUserUs, that.userByIdUserUserUs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubcommentReview, contentSubcommentReview, likesQuantitySubcommentReview, userByIdUserUserUs);
    }

    @ManyToOne
    @JoinColumn(name = "id_user_user_us", referencedColumnName = "id_user")
    public model.UserEntity getUserByIdUserUserUs() {
        return userByIdUserUserUs;
    }

    public void setUserByIdUserUserUs(model.UserEntity userByIdUserUserUs) {
        this.userByIdUserUserUs = userByIdUserUserUs;
    }

    @Override
    public String toString() {
        return "model.SubcommentReviewEntity{" +
                "idSubcommentReview=" + idSubcommentReview +
                ", contentSubcommentReview='" + contentSubcommentReview + '\'' +
                ", likesQuantitySubcommentReview=" + likesQuantitySubcommentReview +
                ", userByIdUserUserUs=" + userByIdUserUserUs +
                '}';
    }
}
