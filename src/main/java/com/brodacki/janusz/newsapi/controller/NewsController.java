package com.brodacki.janusz.newsapi.controller;



import com.brodacki.janusz.newsapi.jasonModel.NewsJasonModel;
import com.brodacki.janusz.newsapi.model.News;
import com.brodacki.janusz.newsapi.model.Result;
import com.brodacki.janusz.newsapi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

   private NewsService newsService;


   @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "listNews")
    public String getAllNews(Model model){
        List<NewsJasonModel> news = newsService.getListNews();
        model.addAttribute("news", news);
        return "news";
    }
    @RequestMapping(method = RequestMethod.GET, value = "listApi")
    public String getAllNewsFromApi(Model model){
       News result = newsService.getNews();
       model.addAttribute("news", result);
       return "news";

    }

}
