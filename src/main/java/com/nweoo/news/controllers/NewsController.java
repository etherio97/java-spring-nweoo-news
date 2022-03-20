package com.nweoo.news.controllers;

import java.io.IOException;
import java.util.List;

import com.nweoo.news.model.Article;
import com.nweoo.news.service.imp.NewsServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsServiceImp newsService;

    @GetMapping("articles")
    public List<Article> getArticles() throws IOException {
        return newsService.getArticles();
    }
}