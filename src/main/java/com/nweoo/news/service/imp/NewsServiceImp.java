package com.nweoo.news.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.nweoo.news.model.Article;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NewsServiceImp {

    public List<Article> getArticles(Integer limit, Optional<String> paging) throws IOException {
        List<Article> articles = new ArrayList<>();
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("https://api.nweoo.com/news/articles").queryParam("limit", limit);
        if (! paging) uri.queryParam("paging", paging);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(uri.encode().toUriString(), String.class);
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
