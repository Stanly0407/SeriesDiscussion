package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "series", schema = "seriesdiscuss", catalog = "")
public class SeriesEntity {
    private long idSeries;
    private String titleSeries;
    private String contentSeries;
    private String country;
    private String genreOne;
    private String genreTwo;
    private int year;
    private int seasons;
    private long likesQuantitySeries;
    private long commentQuantitySeries;

    public SeriesEntity(String titleSeries, String contentSeries, String country, String genreOne, String genreTwo, int year, int seasons, long likesQuantitySeries, long commentQuantitySeries) {
        this.titleSeries = titleSeries;
        this.contentSeries = contentSeries;
        this.country = country;
        this.genreOne = genreOne;
        this.genreTwo = genreTwo;
        this.year = year;
        this.seasons = seasons;
        this.likesQuantitySeries = likesQuantitySeries;
        this.commentQuantitySeries = commentQuantitySeries;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_series", nullable = false)
    public long getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(long idSeries) {
        this.idSeries = idSeries;
    }

    @Basic
    @Column(name = "title_series", nullable = true, length = 255)
    public String getTitleSeries() {
        return titleSeries;
    }

    public void setTitleSeries(String titleSeries) {
        this.titleSeries = titleSeries;
    }

    @Basic
    @Column(name = "content_series", nullable = true, length = 2040)
    public String getContentSeries() {
        return contentSeries;
    }

    public void setContentSeries(String contentSeries) {
        this.contentSeries = contentSeries;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "genre_one", nullable = true, length = 255)
    public String getGenreOne() {
        return genreOne;
    }

    public void setGenreOne(String genreOne) {
        this.genreOne = genreOne;
    }

    @Basic
    @Column(name = "genre_two", nullable = true, length = 255)
    public String getGenreTwo() {
        return genreTwo;
    }

    public void setGenreTwo(String genreTwo) {
        this.genreTwo = genreTwo;
    }

    @Basic
    @Column(name = "year", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "seasons", nullable = true)
    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    @Basic
    @Column(name = "likes_quantity_series", nullable = true)
    public Long getLikesQuantitySeries() {
        return likesQuantitySeries;
    }

    public void setLikesQuantitySeries(Long likesQuantitySeries) {
        this.likesQuantitySeries = likesQuantitySeries;
    }

    @Basic
    @Column(name = "comment_quantity_series", nullable = true)
    public Long getCommentQuantitySeries() {
        return commentQuantitySeries;
    }

    public void setCommentQuantitySeries(Long commentQuantitySeries) {
        this.commentQuantitySeries = commentQuantitySeries;
    }

    public SeriesEntity(){}

    public SeriesEntity(long idSeries, String titleSeries, String contentSeries, String country, String genreOne, String genreTwo, int year, int seasons, long likesQuantitySeries, long commentQuantitySeries) {
        this.idSeries = idSeries;
        this.titleSeries = titleSeries;
        this.contentSeries = contentSeries;
        this.country = country;
        this.genreOne = genreOne;
        this.genreTwo = genreTwo;
        this.year = year;
        this.seasons = seasons;
        this.likesQuantitySeries = likesQuantitySeries;
        this.commentQuantitySeries = commentQuantitySeries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesEntity that = (SeriesEntity) o;
        return idSeries == that.idSeries &&
                year == that.year &&
                seasons == that.seasons &&
                likesQuantitySeries == that.likesQuantitySeries &&
                commentQuantitySeries == that.commentQuantitySeries &&
                Objects.equals(titleSeries, that.titleSeries) &&
                Objects.equals(contentSeries, that.contentSeries) &&
                Objects.equals(country, that.country) &&
                Objects.equals(genreOne, that.genreOne) &&
                Objects.equals(genreTwo, that.genreTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeries, titleSeries, contentSeries, country, genreOne, genreTwo, year, seasons, likesQuantitySeries, commentQuantitySeries);
    }

    @Override
    public String toString() {
        return "model.SeriesEntity{" +
                "idSeries=" + idSeries +
                ", titleSeries='" + titleSeries + '\'' +
                ", contentSeries='" + contentSeries + '\'' +
                ", country='" + country + '\'' +
                ", genreOne='" + genreOne + '\'' +
                ", genreTwo='" + genreTwo + '\'' +
                ", year=" + year +
                ", seasons=" + seasons +
                ", likesQuantitySeries=" + likesQuantitySeries +
                ", commentQuantitySeries=" + commentQuantitySeries +
                '}';
    }
}
