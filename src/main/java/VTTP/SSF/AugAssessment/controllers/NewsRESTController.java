package VTTP.SSF.AugAssessment.controllers;

import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VTTP.SSF.AugAssessment.services.NewsService;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@RestController
@RequestMapping(path="/news")
public class NewsRESTController {
    
    private static final String PACKAGE_ID = null;
    @Autowired
    private NewsService newsSvc;

    // Errors here
    // @GetMapping(produces = "application/json")
    // public ResponseEntity<String> getArticlesAsCSV (
    //     @PathVariable(name="newsId") String newsId) {
    //         ResponseEntity<String> name = getArticlesAsCSV(newsId);
    //         if (newsId ==null || !newsId.startsWith(PACKAGE_ID)){
    //             String error =  " error :  Cannot find news article %s".formatted(newsId);

            //     return ResponseEntity
            //     .badRequest()
            //     .body(error);

            // }

        // }
        // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> getArticlesAsJson(
                @RequestParam(name = "newsId") String newsId) {
    
                    if (newsId ==null || !newsId.startsWith(PACKAGE_ID)){
                JsonObject errResp = Json
                        .createObjectBuilder()
                        .add("error", ":  Cannot find news article %s".formatted(newsId))
                        .build();
                String payload = errResp.toString();
                
                return ResponseEntity
                        .badRequest() 
                        .body(payload);
            }
            
    
        
            JsonObjectBuilder builder = Json
                    .createObjectBuilder()
                    .add("newsId", newsId);
    
            
            JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
            // for (String n: news)
                // arrBuilder.add(n);
        
            builder = builder.add("news", arrBuilder);
    

            JsonObject resp = builder.build();
    
            return ResponseEntity.ok(resp.toString());
        }
    

}
