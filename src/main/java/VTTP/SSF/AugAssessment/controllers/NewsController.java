package VTTP.SSF.AugAssessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import VTTP.SSF.AugAssessment.models.News;
import VTTP.SSF.AugAssessment.services.NewsService;

@Controller
@RequestMapping(path="/news", produces = "text/html")
public class NewsController {

    @Autowired
    private NewsService newsSvc;

    @GetMapping
    public String getArticles(Model model, @RequestParam String City) {

        List<News> news = newsSvc.getArticles(id);
        model.addAttribute("id", id);
        model.addAttribute("published_on", published_on);
        model.addAttribute("title", title);
        model.addAttribute("url", url);
        model.addAttribute("imageurl", imageurl);
        model.addAttribute("body", body);
        model.addAttribute("tags", tags);
        model.addAttribute("categories", categories);

        
        return "news";
    }
    
}
