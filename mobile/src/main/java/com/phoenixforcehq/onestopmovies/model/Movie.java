package com.phoenixforcehq.onestopmovies.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("vote_count")
    int voteCount;
    @SerializedName("id")
    int id;
//    @SerializedName("video")
//    String video;
    @SerializedName("vote_average")
    double voteAverage;
    @SerializedName("title")
    String title;
    @SerializedName("popularity")
    double popularity;
    @SerializedName("poster_path")
    String posterPath;
    @SerializedName("original_language")
    String orgLang;
    @SerializedName("original_title")
    String orgTitle;
    @SerializedName("genre_ids")
    int[] genreIds;
    @SerializedName("backdrop_path")
    String bacdropPath;
    @SerializedName("adult")
    boolean adult;
    @SerializedName("release_date")
    String releaseDate;
    @SerializedName("overview")
    String overView;

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOrgLang() {
        return orgLang;
    }

    public void setOrgLang(String orgLang) {
        this.orgLang = orgLang;
    }

    public String getOrgTitle() {
        return orgTitle;
    }

    public void setOrgTitle(String orgTitle) {
        this.orgTitle = orgTitle;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(int[] genreIds) {
        this.genreIds = genreIds;
    }

    public String getBacdropPath() {
        return bacdropPath;
    }

    public void setBacdropPath(String bacdropPath) {
        this.bacdropPath = bacdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }
}
