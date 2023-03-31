package com.FAM.newspage.FAM.Controller;

import com.FAM.newspage.FAM.Model.FreeGame;
import com.FAM.newspage.FAM.Service.FreeGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class FreeGameController {

    private FreeGameService gameService;

    @Autowired
    public void setService(FreeGameService cardService) {
        this.gameService = cardService;
    }

    @GetMapping(value = "/api/free_games")
    public List<FreeGame> getAllGames() throws IOException {
        return gameService.getAllGames();

    }
    @GetMapping(value = "/api/free_games/filter")
    public List<FreeGame> getGamesByFilter(@RequestParam Map<String,String> allParams) throws IOException {
        return gameService.getGamesByFilter(allParams);
    }
}