package com.wwwy.liuxing.movie.dto;

import java.io.Serializable;

/**
 *
 * @author W1665
 * @date 2018/4/10
 */
public class MovieDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 电影ID
     */
    private Integer movieId;

    /**
     * 电影名字
     */
    private String movieName;

    /**
     * 电影导演
     */
    private String movieDirector;

    /**
     * 电影主演
     */
    private String movieStar;

    /**
     * 电影类型
     */
    private String movieType;

    /**
     * 电影制作国家
     */
    private String movieCountry;

    /**
     * 电影语言
     */
    private String movieLanguage;

    /**
     * 电影时长
     */
    private String movieTime;

    /**
     * 电影剧情详情
     */
    private String movieDetails;

    /**
     * 电影上映日期
     */
    private String movieDate;

    /**
     * 电影评分
     */
    private String movieScore;

    /**
     * 电影图片
     */
    private String movieImg;

    /**
     * 电影预告链接
     */
    private String moviePreparation;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieStar() {
        return movieStar;
    }

    public void setMovieStar(String movieStar) {
        this.movieStar = movieStar;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(String movieCountry) {
        this.movieCountry = movieCountry;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public String getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(String movieDetails) {
        this.movieDetails = movieDetails;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(String movieScore) {
        this.movieScore = movieScore;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }

    public String getMoviePreparation() {
        return moviePreparation;
    }

    public void setMoviePreparation(String moviePreparation) {
        this.moviePreparation = moviePreparation;
    }

    public MovieDTO() {
        super();
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieStar='" + movieStar + '\'' +
                ", movieType='" + movieType + '\'' +
                ", movieCountry='" + movieCountry + '\'' +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", movieTime='" + movieTime + '\'' +
                ", movieDetails='" + movieDetails + '\'' +
                ", movieDate='" + movieDate + '\'' +
                ", movieScore='" + movieScore + '\'' +
                ", movieImg='" + movieImg + '\'' +
                ", moviePreparation='" + moviePreparation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDTO movieDTO = (MovieDTO) o;

        if (movieId != null ? !movieId.equals(movieDTO.movieId) : movieDTO.movieId != null) return false;
        if (movieName != null ? !movieName.equals(movieDTO.movieName) : movieDTO.movieName != null) return false;
        if (movieDirector != null ? !movieDirector.equals(movieDTO.movieDirector) : movieDTO.movieDirector != null)
            return false;
        if (movieStar != null ? !movieStar.equals(movieDTO.movieStar) : movieDTO.movieStar != null) return false;
        if (movieType != null ? !movieType.equals(movieDTO.movieType) : movieDTO.movieType != null) return false;
        if (movieCountry != null ? !movieCountry.equals(movieDTO.movieCountry) : movieDTO.movieCountry != null)
            return false;
        if (movieLanguage != null ? !movieLanguage.equals(movieDTO.movieLanguage) : movieDTO.movieLanguage != null)
            return false;
        if (movieTime != null ? !movieTime.equals(movieDTO.movieTime) : movieDTO.movieTime != null) return false;
        if (movieDetails != null ? !movieDetails.equals(movieDTO.movieDetails) : movieDTO.movieDetails != null)
            return false;
        if (movieDate != null ? !movieDate.equals(movieDTO.movieDate) : movieDTO.movieDate != null) return false;
        if (movieScore != null ? !movieScore.equals(movieDTO.movieScore) : movieDTO.movieScore != null) return false;
        if (movieImg != null ? !movieImg.equals(movieDTO.movieImg) : movieDTO.movieImg != null) return false;
        return moviePreparation != null ? moviePreparation.equals(movieDTO.moviePreparation) : movieDTO.moviePreparation == null;

    }

    @Override
    public int hashCode() {
        int result = movieId != null ? movieId.hashCode() : 0;
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (movieDirector != null ? movieDirector.hashCode() : 0);
        result = 31 * result + (movieStar != null ? movieStar.hashCode() : 0);
        result = 31 * result + (movieType != null ? movieType.hashCode() : 0);
        result = 31 * result + (movieCountry != null ? movieCountry.hashCode() : 0);
        result = 31 * result + (movieLanguage != null ? movieLanguage.hashCode() : 0);
        result = 31 * result + (movieTime != null ? movieTime.hashCode() : 0);
        result = 31 * result + (movieDetails != null ? movieDetails.hashCode() : 0);
        result = 31 * result + (movieDate != null ? movieDate.hashCode() : 0);
        result = 31 * result + (movieScore != null ? movieScore.hashCode() : 0);
        result = 31 * result + (movieImg != null ? movieImg.hashCode() : 0);
        result = 31 * result + (moviePreparation != null ? moviePreparation.hashCode() : 0);
        return result;
    }
}
