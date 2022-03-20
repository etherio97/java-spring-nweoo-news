package com.nweoo.news.service;

import java.io.IOException;
import java.util.List;

import com.nweoo.news.model.Article;

public interface NewsService {
    public List<Article> getArticles() throws IOException;
}
