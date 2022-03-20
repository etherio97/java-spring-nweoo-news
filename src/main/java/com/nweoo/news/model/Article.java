package com.nweoo.news.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Article implements Serializable {
    public String id;
    public String title;
    public String content;
    public String image;
    public String source;
    public String caption;
    public String link;
    public String $ref;
    public String article_id;
    public String video_id;
    public String photo_id;
    public String post_id;
    public String message_id;
    public Long timestamp;
}
