package com.FAM.newspage.FAM.Controller;

import com.FAM.newspage.FAM.Model.GameNews;
import com.FAM.newspage.FAM.Service.GameNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GameNewsController {

    private GameNewsService gameNewsService;

    @Autowired
    public void setService(GameNewsService newsService) {
        this.gameNewsService = newsService;
    }

    @GetMapping(value = "/api/news/ign")
    public List<GameNews> getIGNData() throws IOException {
        return gameNewsService.getIGNNews();
    }

    @GetMapping(value = "/api/news/gamestar")
    public List<GameNews> getGamestarData() throws IOException {
        return gameNewsService.getGamestarNews();
    }
}
