package com.csc340.disneyChars;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    @GetMapping("/disneyChars")
    public Object getDisneyChars() {
        try {
            String url = "https://api.disneyapi.dev/character";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            List<DisneyCharacter> characterList = new ArrayList<>();


            for (JsonNode rt : root) {
                //Extract relevant info from the response and use it for what you want, in this case build a Brewery object
                String name = rt.get("name").asText();
                String id = rt.get("_id").asText();
                String url2 = rt.get("sourceUrl").asText();

                DisneyCharacter character = new DisneyCharacter(id,name, url2);
                characterList.add(character);
            }
            return characterList;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /disneyChars";
        }
    }
}
