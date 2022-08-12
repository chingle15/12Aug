package VTTP.SSF.AugAssessment.services;

import java.io.Reader;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import VTTP.SSF.AugAssessment.models.News;
import VTTP.SSF.AugAssessment.repository.NewsRepository;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;



@Service 
public class NewsService {
    private static final String URL = "https://min-api.cryptocompare.com/data/v2/news/?lang=EN";

    @Autowired
    private NewsRepository newsRepo;

    public List<News> getArticles(String newsId) {

        Optional<String> opt = newsRepo.get(newsId);
        String payload;

        System.out.printf(">>> newsId: %s\n", newsId);

            try {
                String url = UriComponentsBuilder.fromUriString(URL)
                    .queryParam("q", URLEncoder.encode(newsId, "UTF-8"))
                    .queryParam("appid", key)
                    .toUriString();

                RequestEntity<Void> req = RequestEntity.get(url).build();

                
                RestTemplate template = new RestTemplate();
                ResponseEntity<String> resp;

                
                resp = template.exchange(req, String.class);

                
                payload = resp.getBody();
                System.out.println("payload: " + payload);} }

                public List<News> saveArticles(String news){

                newsRepo.save(newsId, payload);
             catch (Exception ex) {
                System.err.printf("Error: %s\n", ex.getMessage());
                return Collections.emptyList();
            }
         else {
            
            payload = opt.get();
            System.out.printf(">>>> cache: %s\n", payload);
        } }

    
        Reader strReader = new StringReader(payload);
        
        JsonReader jsonReader = Json.createReader(strReader);
        
        JsonObject newsResult = jsonReader.readObject();
        JsonArray newsId = newsResult.getJsonArray("news");
        List<News> list = new LinkedList<>();
        for (int i = 0; i < newsID.size(); i++) {
            JsonObject jo = newsId.getJsonObject(i);
            list.add(((News) newsId).create(jo));
        }
        return list;
    }
    

