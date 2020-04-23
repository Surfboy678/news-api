package com.brodacki.janusz.newsapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
@Configuration
public class DbConfig {


    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

   //@EventListener(ApplicationReadyEvent.class)
   //public void init() {
     //   String sql = "CREATE TABLE news(id int auto_increment, type varchar (255), section_name varchar(255)," +
       //         " web_title varchar (255), web_url varchar (255), primary key(id))";
        //getJdbcTemplate().update(sql);
    //}
}
