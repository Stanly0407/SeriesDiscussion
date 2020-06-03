package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment_review", schema = "seriesdiscuss", catalog = "")
public class CommentReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment_review", nullable = false)
    private long idCommentReview;

    @Column(name = "content_comment_review", nullable = true, length = 2040)
    private String contentCommentReview;

    @Column(name = "likes_quantity_comment_review", nullable = true)
    private long likesQuantityCommentReview;

    @ManyToOne
    @JoinColumn(name = "id_rev_rev", referencedColumnName = "id_review")
    private ReviewEntity reviewByIdRevRev;

    @ManyToOne
    @JoinColumn(name = "email_us_user", referencedColumnName = "email", nullable = false)
    private UserEntity userByEmailUsUser;

    public long getIdCommentReview() {
        return idCommentReview;
    }

    public void setIdCommentReview(long idCommentReview) {
        this.idCommentReview = idCommentReview;
    }

    public String getContentCommentReview() {
        return contentCommentReview;
    }

    public void setContentCommentReview(String contentCommentReview) {
        this.contentCommentReview = contentCommentReview;
    }

    public Long getLikesQuantityCommentReview() {
        return likesQuantityCommentReview;
    }

    public void setLikesQuantityCommentReview(Long likesQuantityCommentReview) {
        this.likesQuantityCommentReview = likesQuantityCommentReview;
    }

    public CommentReviewEntity() {
    }

    public CommentReviewEntity(String contentCommentReview, long likesQuantityCommentReview, ReviewEntity reviewByIdRevRev, UserEntity userByEmailUsUser) {
        this.contentCommentReview = contentCommentReview;
        this.likesQuantityCommentReview = likesQuantityCommentReview;
        this.reviewByIdRevRev = reviewByIdRevRev;
        this.userByEmailUsUser = userByEmailUsUser;
    }

    public model.ReviewEntity getReviewByIdRevRev() {
        return reviewByIdRevRev;
    }

    public void setReviewByIdRevRev(model.ReviewEntity reviewByIdRevRev) {
        this.reviewByIdRevRev = reviewByIdRevRev;
    }

    public model.UserEntity getUserByIdUsUser() {
        return userByEmailUsUser;
    }

    public void setUserByIdUsUser(model.UserEntity userByEmailUsUser) {
        this.userByEmailUsUser = userByEmailUsUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentReviewEntity that = (CommentReviewEntity) o;
        return idCommentReview == that.idCommentReview &&
                likesQuantityCommentReview == that.likesQuantityCommentReview &&
                Objects.equals(contentCommentReview, that.contentCommentReview) &&
                Objects.equals(reviewByIdRevRev, that.reviewByIdRevRev) &&
                Objects.equals(userByEmailUsUser, that.userByEmailUsUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommentReview, contentCommentReview, likesQuantityCommentReview, reviewByIdRevRev, userByEmailUsUser);
    }

    @Override
    public String toString() {
        return "CommentReviewEntity{" +
                "idCommentReview=" + idCommentReview +
                ", contentCommentReview='" + contentCommentReview + '\'' +
                ", likesQuantityCommentReview=" + likesQuantityCommentReview +
                ", reviewByIdRevRev=" + reviewByIdRevRev +
                ", userByEmailUsUser=" + userByEmailUsUser +
                '}';
    }
}
