package com.brodacki.janusz.newsapi.service;

import com.brodacki.janusz.newsapi.dao.NewsDaoImpl;
import com.brodacki.janusz.newsapi.jasonModel.NewsJasonModel;
import com.brodacki.janusz.newsapi.model.News;
import com.brodacki.janusz.newsapi.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsService {

    final static Logger logger = LoggerFactory.getLogger(NewsService.class);

    private NewsDaoImpl newsDao;

    @Value("${APPID}")
    private String APPID;

    private final String GET_ALL_URL = "https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2020-01-01";

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public NewsService(NewsDaoImpl newsDao) {
        this.newsDao = newsDao;
    }

    public List<NewsJasonModel> getListNews() {
        return newsDao.getAll();
    }

    public List<Result> getNews() {
        String urlToNews = GET_ALL_URL + APPID;
        News news = restTemplate.getForObject(urlToNews, News.class);
        return news.getResponse().getResults();
    }

    public void saveNews(Result result) {
        logger.error("error");
        newsDao.addNews(result);
    }

    public void updateNews(NewsJasonModel newResult) {
        newsDao.updateNews(newResult);
    }


}
