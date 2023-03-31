package com.FAM.newspage.FAM.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class FreeGame {

    private int id;
    private String title;
    private String thumbnail;
    private String short_description;
    private String game_url;
    private String genre;
    private String platform;
    private String publisher;
    private String developer;
    private int releaseDate;
    private String freetogame_profile_url;
    // getters and setters omitted for brevity



    public FreeGame(int id, String title, String thumbnail, String short_description,
                    String game_url, String genre, String platform, String publisher,
                    String developer, int releaseDate, String freetogame_profile_url) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.short_description = short_description;
        this.game_url = game_url;
        this.genre = genre;
        this.platform = platform;
        this.publisher = publisher;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.freetogame_profile_url = freetogame_profile_url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getGame_url() {
        return game_url;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getFreetogame_profile_url() {
        return freetogame_profile_url;
    }

    @Override
    public String toString() {
        return "FreeGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", short_description='" + short_description + '\'' +
                ", game_url='" + game_url + '\'' +
                ", genre='" + genre + '\'' +
                ", platform='" + platform + '\'' +
                ", publisher='" + publisher + '\'' +
                ", developer='" + developer + '\'' +
                ", releaseDate=" + releaseDate +
                ", freetogame_profile_url='" + freetogame_profile_url + '\'' +
                '}';
    }
}
