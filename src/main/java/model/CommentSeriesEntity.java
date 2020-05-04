package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment_series", schema = "seriesdiscuss", catalog = "")
public class CommentSeriesEntity {
    private long idCommentSeries;
    private String contentCommentSeries;
    private long likesQuantityCommentSeries;
    private SeriesEntity seriesByIdSerSer;
    private UserEntity userByIdUsUs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment_series", nullable = false)
    public long getIdCommentSeries() {
        return idCommentSeries;
    }

    public void setIdCommentSeries(long idCommentSeries) {
        this.idCommentSeries = idCommentSeries;
    }

    @Basic
    @Column(name = "content_comment_series", nullable = true, length = 2040)
    public String getContentCommentSeries() {
        return contentCommentSeries;
    }

    public void setContentCommentSeries(String contentCommentSeries) {
        this.contentCommentSeries = contentCommentSeries;
    }

    @Basic
    @Column(name = "likes_quantity_comment_series", nullable = true)
    public Long getLikesQuantityCommentSeries() {
        return likesQuantityCommentSeries;
    }

    public void setLikesQuantityCommentSeries(Long likesQuantityCommentSeries) {
        this.likesQuantityCommentSeries = likesQuantityCommentSeries;
    }

    public CommentSeriesEntity(){}

    public CommentSeriesEntity(long idCommentSeries, String contentCommentSeries, Long likesQuantityCommentSeries, model.SeriesEntity seriesByIdSerSer, model.UserEntity userByIdUsUs) {
        this.idCommentSeries = idCommentSeries;
        this.contentCommentSeries = contentCommentSeries;
        this.likesQuantityCommentSeries = likesQuantityCommentSeries;
        this.seriesByIdSerSer = seriesByIdSerSer;
        this.userByIdUsUs = userByIdUsUs;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentSeriesEntity that = (CommentSeriesEntity) o;
        return idCommentSeries == that.idCommentSeries &&
                likesQuantityCommentSeries == that.likesQuantityCommentSeries &&
                Objects.equals(contentCommentSeries, that.contentCommentSeries) &&
                Objects.equals(seriesByIdSerSer, that.seriesByIdSerSer) &&
                Objects.equals(userByIdUsUs, that.userByIdUsUs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommentSeries, contentCommentSeries, likesQuantityCommentSeries, seriesByIdSerSer, userByIdUsUs);
    }

    @ManyToOne
    @JoinColumn(name = "id_ser_ser", referencedColumnName = "id_series")
    public model.SeriesEntity getSeriesByIdSerSer() {
        return seriesByIdSerSer;
    }

    public void setSeriesByIdSerSer(model.SeriesEntity seriesByIdSerSer) {
        this.seriesByIdSerSer = seriesByIdSerSer;
    }

    @ManyToOne
    @JoinColumn(name = "id_us_us", referencedColumnName = "id_user")
    public model.UserEntity getUserByIdUsUs() {
        return userByIdUsUs;
    }

    public void setUserByIdUsUs(model.UserEntity userByIdUsUs) {
        this.userByIdUsUs = userByIdUsUs;
    }

    @Override
    public String toString() {
        return "model.CommentSeriesEntity{" +
                "idCommentSeries=" + idCommentSeries +
                ", contentCommentSeries='" + contentCommentSeries + '\'' +
                ", likesQuantityCommentSeries=" + likesQuantityCommentSeries +
                ", seriesByIdSerSer=" + seriesByIdSerSer +
                ", userByIdUsUs=" + userByIdUsUs +
                '}';
    }
}
