package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "review", schema = "seriesdiscuss", catalog = "")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review", nullable = false)
    private long idReview;

    @Column(name = "title_review", nullable = true, length = 255)
    private String titleReview;

    @Column(name = "content_review", nullable = true, length = 2040)
    private String contentReview;

    @Column(name = "likes_quantity_review", nullable = true)
    private long likesQuantityReview;

    @Column(name = "comment_quantity_review", nullable = true)
    private long commentQuantityReview;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_ser", referencedColumnName = "id_series")
    private SeriesEntity seriesByIdSer;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "email_us", referencedColumnName = "email", nullable = false)
    private UserEntity userByEmailUs;

    public long getIdReview() {
        return idReview;
    }

    public void setIdReview(long idReview) {
        this.idReview = idReview;
    }

    public String getTitleReview() {
        return titleReview;
    }

    public void setTitleReview(String titleReview) {
        this.titleReview = titleReview;
    }

    public String getContentReview() {
        return contentReview;
    }

    public void setContentReview(String contentReview) {
        this.contentReview = contentReview;
    }

    public Long getLikesQuantityReview() {
        return likesQuantityReview;
    }

    public void setLikesQuantityReview(Long likesQuantityReview) {
        this.likesQuantityReview = likesQuantityReview;
    }

    public Long getCommentQuantityReview() {
        return commentQuantityReview;
    }

    public void setCommentQuantityReview(Long commentQuantityReview) {
        this.commentQuantityReview = commentQuantityReview;
    }

    public ReviewEntity() {
    }

    public ReviewEntity(String titleReview, String contentReview, long likesQuantityReview, long commentQuantityReview, SeriesEntity seriesByIdSer, UserEntity userByEmailUs) {
        this.titleReview = titleReview;
        this.contentReview = contentReview;
        this.likesQuantityReview = likesQuantityReview;
        this.commentQuantityReview = commentQuantityReview;
        this.seriesByIdSer = seriesByIdSer;
        this.userByEmailUs = userByEmailUs;
    }


    public SeriesEntity getSeriesByIdSer() {
        return seriesByIdSer;
    }

    public void setSeriesByIdSer(SeriesEntity seriesByIdSer) {
        this.seriesByIdSer = seriesByIdSer;
    }

    public UserEntity getUserByEmailUs() {
        return userByEmailUs;
    }

    public void setUserByEmailUs(UserEntity userByEmailUs) {
        this.userByEmailUs = userByEmailUs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewEntity that = (ReviewEntity) o;
        return idReview == that.idReview &&
                likesQuantityReview == that.likesQuantityReview &&
                commentQuantityReview == that.commentQuantityReview &&
                Objects.equals(titleReview, that.titleReview) &&
                Objects.equals(contentReview, that.contentReview) &&
                Objects.equals(seriesByIdSer, that.seriesByIdSer) &&
                Objects.equals(userByEmailUs, that.userByEmailUs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReview, titleReview, contentReview, likesQuantityReview, commentQuantityReview, seriesByIdSer, userByEmailUs);
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "idReview=" + idReview +
                ", titleReview='" + titleReview + '\'' +
                ", contentReview='" + contentReview + '\'' +
                ", likesQuantityReview=" + likesQuantityReview +
                ", commentQuantityReview=" + commentQuantityReview +
                ", seriesByIdSer=" + seriesByIdSer +
                ", userByEmailUs=" + userByEmailUs +
                '}';
    }
}
