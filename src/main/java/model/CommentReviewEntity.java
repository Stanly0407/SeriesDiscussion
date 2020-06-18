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
    @JoinColumn(name = "username_us_user", referencedColumnName = "username", nullable = false)
    private User userByUsernameUsUser;

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


    public model.ReviewEntity getReviewByIdRevRev() {
        return reviewByIdRevRev;
    }

    public void setReviewByIdRevRev(model.ReviewEntity reviewByIdRevRev) {
        this.reviewByIdRevRev = reviewByIdRevRev;
    }

    public CommentReviewEntity(String contentCommentReview, long likesQuantityCommentReview, ReviewEntity reviewByIdRevRev, User userByUsernameUsUser) {
        this.contentCommentReview = contentCommentReview;
        this.likesQuantityCommentReview = likesQuantityCommentReview;
        this.reviewByIdRevRev = reviewByIdRevRev;
        this.userByUsernameUsUser = userByUsernameUsUser;
    }

    public User getUserByUsernameUsUser() {
        return userByUsernameUsUser;
    }

    public void setUserByUsernameUsUser(User userByUsernameUsUser) {
        this.userByUsernameUsUser = userByUsernameUsUser;
    }

    @Override
    public String toString() {
        return "CommentReviewEntity{" +
                "idCommentReview=" + idCommentReview +
                ", contentCommentReview='" + contentCommentReview + '\'' +
                ", likesQuantityCommentReview=" + likesQuantityCommentReview +
                ", reviewByIdRevRev=" + reviewByIdRevRev +
                ", userByUsernameUsUser=" + userByUsernameUsUser +
                '}';
    }
}
