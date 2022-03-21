package com.nweoo.news.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.nweoo.news.model.Article;
import com.nweoo.news.service.imp.NewsServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsServiceImp newsService;

    @GetMapping("articles")
    public List<Article> getArticles(@RequestParam(defaultValue=15) Integer limit, @RequestParam Optional<String> paging) throws IOException {
        return newsService.getArticles(limit, paging);
    }
}
