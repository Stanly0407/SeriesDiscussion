//package model;
//
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "subcomment_review", schema = "seriesdiscuss", catalog = "")
//public class SubcommentReviewEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_subcomment_review", nullable = false)
//    private long idSubcommentReview;
//
//    @Column(name = "content_subcomment_review", nullable = true, length = 2040)
//    private String contentSubcommentReview;
//
//    @Column(name = "likes_quantity_subcomment_review", nullable = true)
//    private long likesQuantitySubcommentReview;
//
//    @ManyToOne
//    @JoinColumn(name = "email_user_user_us", referencedColumnName = "email", nullable = false)
//    private User userByEmailUserUserUs;
//
//
//    public long getIdSubcommentReview() {
//        return idSubcommentReview;
//    }
//
//    public void setIdSubcommentReview(long idSubcommentReview) {
//        this.idSubcommentReview = idSubcommentReview;
//    }
//
//    public String getContentSubcommentReview() {
//        return contentSubcommentReview;
//    }
//
//    public void setContentSubcommentReview(String contentSubcommentReview) {
//        this.contentSubcommentReview = contentSubcommentReview;
//    }
//
//    public Long getLikesQuantitySubcommentReview() {
//        return likesQuantitySubcommentReview;
//    }
//
//    public void setLikesQuantitySubcommentReview(Long likesQuantitySubcommentReview) {
//        this.likesQuantitySubcommentReview = likesQuantitySubcommentReview;
//    }
//
//    public SubcommentReviewEntity(){}
//
//    public SubcommentReviewEntity(String contentSubcommentReview, long likesQuantitySubcommentReview, User userByEmailUserUserUs) {
//       this.contentSubcommentReview = contentSubcommentReview;
//        this.likesQuantitySubcommentReview = likesQuantitySubcommentReview;
//        this.userByEmailUserUserUs = userByEmailUserUserUs;
//    }
//
//
//    public User getUserByEmailUserUserUs() {
//        return userByEmailUserUserUs;
//    }
//
//    public void setUserByEmailUserUserUs(User userByEmailUserUserUs) {
//        this.userByEmailUserUserUs = userByEmailUserUserUs;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SubcommentReviewEntity that = (SubcommentReviewEntity) o;
//        return idSubcommentReview == that.idSubcommentReview &&
//                likesQuantitySubcommentReview == that.likesQuantitySubcommentReview &&
//                Objects.equals(contentSubcommentReview, that.contentSubcommentReview) &&
//                Objects.equals(userByEmailUserUserUs, that.userByEmailUserUserUs);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idSubcommentReview, contentSubcommentReview, likesQuantitySubcommentReview, userByEmailUserUserUs);
//    }
//
//    @Override
//    public String toString() {
//        return "SubcommentReviewEntity{" +
//                "idSubcommentReview=" + idSubcommentReview +
//                ", contentSubcommentReview='" + contentSubcommentReview + '\'' +
//                ", likesQuantitySubcommentReview=" + likesQuantitySubcommentReview +
//                ", userByEmailUserUserUs=" + userByEmailUserUserUs +
//                '}';
//    }
//}
