package model;


import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
@Table(name = "subcomment_review", schema = "seriesdiscuss", catalog = "")
public class SubcommentReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcomment_review", nullable = false)
    private long idSubcommentReview;

    @Column(name = "content_subcomment_review", nullable = true, length = 2040)
    private String contentSubcommentReview;

    @Column(name = "likes_quantity_subcomment_review", nullable = true)
    private long likesQuantitySubcommentReview;

    @ManyToOne
    @JoinColumn(name = "username_user_user_us", referencedColumnName = "username", nullable = false)
    private User userByUsernameUserUserUs;


    public long getIdSubcommentReview() {
        return idSubcommentReview;
    }

    public void setIdSubcommentReview(long idSubcommentReview) {
        this.idSubcommentReview = idSubcommentReview;
    }

    public String getContentSubcommentReview() {
        return contentSubcommentReview;
    }

    public void setContentSubcommentReview(String contentSubcommentReview) {
        this.contentSubcommentReview = contentSubcommentReview;
    }

    public Long getLikesQuantitySubcommentReview() {
        return likesQuantitySubcommentReview;
    }

    public void setLikesQuantitySubcommentReview(Long likesQuantitySubcommentReview) {
        this.likesQuantitySubcommentReview = likesQuantitySubcommentReview;
    }

    public SubcommentReviewEntity(){}

    public SubcommentReviewEntity(String contentSubcommentReview, long likesQuantitySubcommentReview, User userByUsernameUserUserUs) {
        this.contentSubcommentReview = contentSubcommentReview;
        this.likesQuantitySubcommentReview = likesQuantitySubcommentReview;
        this.userByUsernameUserUserUs = userByUsernameUserUserUs;
    }


    public User getUserByUsernameUserUserUs() {
        return userByUsernameUserUserUs;
    }

    public void setUserByUsernameUserUserUs(User userByUsernameUserUserUs) {
        this.userByUsernameUserUserUs = userByUsernameUserUserUs;
    }



}
