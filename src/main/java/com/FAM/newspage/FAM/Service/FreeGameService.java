package com.FAM.newspage.FAM.Service;

import com.FAM.newspage.FAM.Model.FreeGame;
import com.FAM.newspage.FAM.Util.HttpUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import static com.FAM.newspage.FAM.Util.HttpUtil.sendGetRequest;

@Service
public class FreeGameService {

    private static final String BASE_URL = "https://www.freetogame.com/api";
    private final Gson gson = new Gson();


    public List<FreeGame> getAllGames() throws IOException {
        String url = BASE_URL + "/games";
        String responseBody = sendGetRequest(url);
        return parseGames(responseBody);
    }

    public List<FreeGame> getGamesByFilter(Map<String, String> allParams) throws IOException {
        List<String> queryParams = new ArrayList<>();
        for(String param:allParams.keySet()){
            queryParams.add(param+"="+allParams.get(param));
        }
        String queryString = String.join("&",queryParams);
        String url = BASE_URL + "/filter?"+queryString;
        System.out.println(url);
        String responseBody = sendGetRequest(url);
        return parseGames(responseBody);
    }

    public FreeGame getGameById(int id) throws IOException {
        String url = BASE_URL + "/game?id=" + id;
        String responseBody = sendGetRequest(url);
        return parseGame(responseBody);
    }

    private List<FreeGame> parseGames(String responseBody) {
        // parse response body using Gson
        Type gameListType = new TypeToken<List<FreeGame>>() {}.getType();
        List<FreeGame> games = gson.fromJson(responseBody, gameListType);
        return games;
    }

    private FreeGame parseGame(String responseBody) {
        // parse response body using Gson
        FreeGame game = gson.fromJson(responseBody, FreeGame.class);

        return game;

    }
}
