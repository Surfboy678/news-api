package com.brodacki.janusz.newsapi.dao;

import com.brodacki.janusz.newsapi.jasonModel.NewsJasonModel;
import com.brodacki.janusz.newsapi.model.Result;
import com.brodacki.janusz.newsapi.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class NewsDaoImpl {



    private JdbcTemplate jdbcTemplate;



    @Autowired
    public NewsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<NewsJasonModel> getAll() {
        List<NewsJasonModel> newsList = new ArrayList<>();
        String sql = "SELECT * FROM news ";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> {
            newsList.add(new NewsJasonModel(
                    String.valueOf(element.get("type")),
                    String.valueOf(element.get("section_name")),
                    String.valueOf(element.get("web_title"))));
        });
        return newsList;
    }

    public void addNews(Result result) {
        NewsJasonModel newsJasonModel = new NewsJasonModel(result.getType(), result.getSectionName(), result.getWebTitle());
        String sql = "INSERT INTO news(type, section_name, web_title)  VALUES (?,?,?)";
        jdbcTemplate.update(sql, newsJasonModel.getType(), newsJasonModel.getSectionName(), newsJasonModel.getWebTitle());
    }
    public void updateNews(NewsJasonModel newResult){
        NewsJasonModel newsJasonModel = new NewsJasonModel(newResult.getType(), newResult.getSectionName(), newResult.getWebTitle());
        String sql = "UPDATE news SET type =?, section_name = ? WHERE web_title = ?";
        jdbcTemplate.update(sql, newsJasonModel.getType(), newsJasonModel.getSectionName(), newsJasonModel.getWebTitle());
    }

    public NewsJasonModel getOne(String webTitle) {
        String sql = "SELECT * FROM news WHERE web_title = ? ";
        return jdbcTemplate.queryForObject(
                sql, (resultSet, i) -> new NewsJasonModel (
                       resultSet.getString("type"),
                       resultSet.getNString("section_name"),
                        resultSet.getString("web_title")), webTitle);
    }

}

