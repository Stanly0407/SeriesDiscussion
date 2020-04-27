package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "review", schema = "seriesdiscuss", catalog = "")
public class ReviewEntity {
    private long idReview;
    private String titleReview;
    private String contentReview;
    private long likesQuantityReview;
    private long commentQuantityReview;
    private SeriesEntity seriesByIdSer;
    private UserEntity userByIdUs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review", nullable = false)
    public long getIdReview() {
        return idReview;
    }

    public void setIdReview(long idReview) {
        this.idReview = idReview;
    }

    @Basic
    @Column(name = "title_review", nullable = true, length = 255)
    public String getTitleReview() {
        return titleReview;
    }

    public void setTitleReview(String titleReview) {
        this.titleReview = titleReview;
    }

    @Basic
    @Column(name = "content_review", nullable = true, length = 2040)
    public String getContentReview() {
        return contentReview;
    }

    public void setContentReview(String contentReview) {
        this.contentReview = contentReview;
    }

    @Basic
    @Column(name = "likes_quantity_review", nullable = true)
    public Long getLikesQuantityReview() {
        return likesQuantityReview;
    }

    public void setLikesQuantityReview(Long likesQuantityReview) {
        this.likesQuantityReview = likesQuantityReview;
    }

    @Basic
    @Column(name = "comment_quantity_review", nullable = true)
    public Long getCommentQuantityReview() {
        return commentQuantityReview;
    }

    public void setCommentQuantityReview(Long commentQuantityReview) {
        this.commentQuantityReview = commentQuantityReview;
    }

    public ReviewEntity(){}

    public ReviewEntity(long idReview, String titleReview, String contentReview, Long likesQuantityReview, Long commentQuantityReview, model.SeriesEntity seriesByIdSer, model.UserEntity userByIdUs) {
        this.idReview = idReview;
        this.titleReview = titleReview;
        this.contentReview = contentReview;
        this.likesQuantityReview = likesQuantityReview;
        this.commentQuantityReview = commentQuantityReview;
        this.seriesByIdSer = seriesByIdSer;
        this.userByIdUs = userByIdUs;
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
                Objects.equals(userByIdUs, that.userByIdUs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReview, titleReview, contentReview, likesQuantityReview, commentQuantityReview, seriesByIdSer, userByIdUs);
    }

    @ManyToOne
    @JoinColumn(name = "id_ser", referencedColumnName = "id_series")
    public model.SeriesEntity getSeriesByIdSer() {
        return seriesByIdSer;
    }

    public void setSeriesByIdSer(model.SeriesEntity seriesByIdSer) {
        this.seriesByIdSer = seriesByIdSer;
    }

    @ManyToOne
    @JoinColumn(name = "id_us", referencedColumnName = "id_user")
    public model.UserEntity getUserByIdUs() {
        return userByIdUs;
    }

    public void setUserByIdUs(model.UserEntity userByIdUs) {
        this.userByIdUs = userByIdUs;
    }

    @Override
    public String toString() {
        return "model.ReviewEntity{" +
                "idReview=" + idReview +
                ", titleReview='" + titleReview + '\'' +
                ", contentReview='" + contentReview + '\'' +
                ", likesQuantityReview=" + likesQuantityReview +
                ", commentQuantityReview=" + commentQuantityReview +
                ", seriesByIdSer=" + seriesByIdSer +
                ", userByIdUs=" + userByIdUs +
                '}';
    }
}
