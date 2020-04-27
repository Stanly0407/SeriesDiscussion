package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment_review", schema = "seriesdiscuss", catalog = "")
public class CommentReviewEntity {
    private long idCommentReview;
    private String contentCommentReview;
    private long likesQuantityCommentReview;
    private ReviewEntity reviewByIdRevRev;
    private UserEntity userByIdUsUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment_review", nullable = false)
    public long getIdCommentReview() {
        return idCommentReview;
    }

    public void setIdCommentReview(long idCommentReview) {
        this.idCommentReview = idCommentReview;
    }

    @Basic
    @Column(name = "content_comment_review", nullable = true, length = 2040)
    public String getContentCommentReview() {
        return contentCommentReview;
    }

    public void setContentCommentReview(String contentCommentReview) {
        this.contentCommentReview = contentCommentReview;
    }

    @Basic
    @Column(name = "likes_quantity_comment_review", nullable = true)
    public Long getLikesQuantityCommentReview() {
        return likesQuantityCommentReview;
    }

    public void setLikesQuantityCommentReview(Long likesQuantityCommentReview) {
        this.likesQuantityCommentReview = likesQuantityCommentReview;
    }

    public CommentReviewEntity(){}

    public CommentReviewEntity(long idCommentReview, String contentCommentReview, Long likesQuantityCommentReview, model.ReviewEntity reviewByIdRevRev, model.UserEntity userByIdUsUser) {
        this.idCommentReview = idCommentReview;
        this.contentCommentReview = contentCommentReview;
        this.likesQuantityCommentReview = likesQuantityCommentReview;
        this.reviewByIdRevRev = reviewByIdRevRev;
        this.userByIdUsUser = userByIdUsUser;
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
                Objects.equals(userByIdUsUser, that.userByIdUsUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommentReview, contentCommentReview, likesQuantityCommentReview, reviewByIdRevRev, userByIdUsUser);
    }

    @ManyToOne
    @JoinColumn(name = "id_rev_rev", referencedColumnName = "id_review")
    public model.ReviewEntity getReviewByIdRevRev() {
        return reviewByIdRevRev;
    }

    public void setReviewByIdRevRev(model.ReviewEntity reviewByIdRevRev) {
        this.reviewByIdRevRev = reviewByIdRevRev;
    }

    @ManyToOne
    @JoinColumn(name = "id_us_user", referencedColumnName = "id_user")
    public model.UserEntity getUserByIdUsUser() {
        return userByIdUsUser;
    }

    public void setUserByIdUsUser(model.UserEntity userByIdUsUser) {
        this.userByIdUsUser = userByIdUsUser;
    }
}
