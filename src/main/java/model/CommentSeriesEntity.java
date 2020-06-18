package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment_series", schema = "seriesdiscuss", catalog = "")
public class CommentSeriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment_series", nullable = false)
    private long idCommentSeries;

    @Column(name = "content_comment_series", nullable = true, length = 2040)
    private String contentCommentSeries;

    @Column(name = "likes_quantity_comment_series", nullable = true)
    private long likesQuantityCommentSeries;

    @ManyToOne
    @JoinColumn(name = "id_ser_ser", referencedColumnName = "id_series")
    private SeriesEntity seriesByIdSerSer;

    @ManyToOne
    @JoinColumn(name = "username_us_us", referencedColumnName = "username", nullable = false)
    private User userByUsernamelUsUs;


    public long getIdCommentSeries() {
        return idCommentSeries;
    }

    public void setIdCommentSeries(long idCommentSeries) {
        this.idCommentSeries = idCommentSeries;
    }

    public String getContentCommentSeries() {
        return contentCommentSeries;
    }

    public void setContentCommentSeries(String contentCommentSeries) {
        this.contentCommentSeries = contentCommentSeries;
    }

    public Long getLikesQuantityCommentSeries() {
        return likesQuantityCommentSeries;
    }

    public void setLikesQuantityCommentSeries(Long likesQuantityCommentSeries) {
        this.likesQuantityCommentSeries = likesQuantityCommentSeries;
    }

    public CommentSeriesEntity() {
    }

    public CommentSeriesEntity(String contentCommentSeries, long likesQuantityCommentSeries, SeriesEntity seriesByIdSerSer, User userByUsernamelUsUs) {
        this.contentCommentSeries = contentCommentSeries;
        this.likesQuantityCommentSeries = likesQuantityCommentSeries;
        this.seriesByIdSerSer = seriesByIdSerSer;
        this.userByUsernamelUsUs = userByUsernamelUsUs;
    }

    public SeriesEntity getSeriesByIdSerSer() {
        return seriesByIdSerSer;
    }

    public void setSeriesByIdSerSer(SeriesEntity seriesByIdSerSer) {
        this.seriesByIdSerSer = seriesByIdSerSer;
    }

    public User getUserByUsernamelUsUs() {
        return userByUsernamelUsUs;
    }

    public void setUserByUsernamelUsUs(User userByUsernamelUsUs) {
        this.userByUsernamelUsUs = userByUsernamelUsUs;
    }

    @Override
    public String toString() {
        return "CommentSeriesEntity{" +
                "idCommentSeries=" + idCommentSeries +
                ", contentCommentSeries='" + contentCommentSeries + '\'' +
                ", likesQuantityCommentSeries=" + likesQuantityCommentSeries +
                ", seriesByIdSerSer=" + seriesByIdSerSer +
                ", userByUsernamelUsUs=" + userByUsernamelUsUs +
                '}';
    }
}
