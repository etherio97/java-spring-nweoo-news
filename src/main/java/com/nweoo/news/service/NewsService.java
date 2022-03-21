package com.nweoo.news.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.nweoo.news.model.Article;

public interface NewsService {
    public List<Article> getArticles(Integer limit, Optional<String> paging) throws IOException;
}
