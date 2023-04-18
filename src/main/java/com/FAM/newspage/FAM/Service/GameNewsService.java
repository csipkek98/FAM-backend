package com.FAM.newspage.FAM.Service;

import com.FAM.newspage.FAM.Model.GameNews;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static com.FAM.newspage.FAM.Util.HttpUtil.sendGetRequest;

@Service
public class GameNewsService {

    private final Gson gson = new Gson();

    private final String BASE_URL ="http://127.0.0.1:5000/";
    public List<GameNews> getIGNNews() throws IOException {
        String url = BASE_URL + "api/news/ign";
        return getGamingNews(url);
    }

    public List<GameNews> getGamestarNews() throws IOException {
        String url = BASE_URL + "/api/news/gamestar";
        return getGamingNews(url);
    }

    private List<GameNews> getGamingNews(String url) throws IOException {
        String responseBody = sendGetRequest(url);
        return parseNews(responseBody);
    }

    private List<GameNews> parseNews(String responseBody) {
        Type gameListType = new TypeToken<List<GameNews>>() {}.getType();
        List<GameNews> news = gson.fromJson(responseBody, gameListType);
        return news;
    }
}
