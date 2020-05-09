package com.brodacki.janusz.newsapi.dao;

import com.brodacki.janusz.newsapi.jasonModel.NewsJasonModel;
import com.brodacki.janusz.newsapi.model.Result;
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
        List<NewsJasonModel> newsList1 = new ArrayList<>();
        String sql = "SELECT * FROM news ";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> {
            newsList1.add(new NewsJasonModel(
                   // String.valueOf(element.get("id")),
                    String.valueOf(element.get("type")),
                    String.valueOf(element.get("section_name")),
                    String.valueOf(element.get("web_title"))));
                    //String.valueOf(element.get("web_url"))));
        });
        return newsList1;
    }

    public void addNews(Result result) {
        NewsJasonModel newsJasonModel = new NewsJasonModel(result.getType(), result.getSectionName(), result.getWebTitle());
        String sql = "INSERT INTO news (?, ?, ?)";
        jdbcTemplate.update(sql,newsJasonModel.getType(), newsJasonModel.getSectionName(), newsJasonModel.getWebTitle() );
    }

}

