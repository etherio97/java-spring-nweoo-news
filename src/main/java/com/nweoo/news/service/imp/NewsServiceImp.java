package com.nweoo.news.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.nweoo.news.model.Article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NewsServiceImp {
    private static Logger log = LoggerFactory.getLogger(NewsServiceImp.class);

    public List<Article> getArticles() throws IOException {
        List<Article> articles = new ArrayList<>();
        String url = "https://api.nweoo.com/news/articles";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            ObjectReader reader = mapper.readerFor(new TypeReference<List<Article>>() {
            });
            articles = reader.readValue(response.getBody());
        } catch (Exception e) {
            throw new IOException(e);
        }
        return articles;
    }
}
