package com.brodacki.janusz.newsapi.controller;



import com.brodacki.janusz.newsapi.dao.NewsDaoImpl;
import com.brodacki.janusz.newsapi.jasonModel.NewsJasonModel;
import com.brodacki.janusz.newsapi.model.Result;
import com.brodacki.janusz.newsapi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsDaoImpl dao;

   private NewsService newsService;


   @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "listNews")
    public String getAllNews(Model model){
        List<NewsJasonModel> news = newsService.getListNews();
        model.addAttribute("news", news);
        return "listnewsindatabeses";
    }
    @RequestMapping(method = RequestMethod.GET, value = "listApi")
    public String getAllNewsFromApi(Model model){
       List<Result> result = newsService.getNews();
       model.addAttribute("news", result);
       return "news";

    }
    @RequestMapping(method = RequestMethod.POST, value = "add")
    public String addNewsToDataBase(@ModelAttribute("result") Result result){
       newsService.saveNews(result);
      return "redirect:/news/listNews";

    }
    @GetMapping(value = "/update/{webTitle}")
    public String updateNews(@PathVariable String webTitle, Result newResult, Model model){
       NewsJasonModel newsJasonModel = dao.getOne(webTitle);
       if(newsJasonModel != null) {
           dao.updateNews(newResult);
           model.addAttribute("newResult", newResult);
           return "updatenews";
       }
        return null;
    }

}
