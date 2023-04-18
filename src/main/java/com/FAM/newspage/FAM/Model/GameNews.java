package com.FAM.newspage.FAM.Model;

public class GameNews {

    private String title;

    private String description;

    private String article_url;

    private String image_url;

    private String time_stamp;

    public GameNews(String title, String description, String article_url, String image_url, String time_stamp) {
        this.title = title;
        this.description = description;
        this.article_url = article_url;
        this.image_url = image_url;
        this.time_stamp = time_stamp;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getArticle_url() {
        return article_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    @Override
    public String toString() {
        return "GameNews{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", article_url='" + article_url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", time_stamp='" + time_stamp + '\'' +
                '}';
    }
}
