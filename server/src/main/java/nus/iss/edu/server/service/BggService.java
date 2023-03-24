package nus.iss.edu.server.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;
import nus.iss.edu.server.Utils;
import nus.iss.edu.server.models.Bgg;
import nus.iss.edu.server.models.GameDetails;
import nus.iss.edu.server.repo.BggRepoImpl;

@Service
public class BggService {

    @Autowired
    private BggRepoImpl repository;

    public JsonObject getGames(Integer limit, Integer offset){

        List<Document> games = repository.getGames(limit, offset);

        System.out.println(">>>>>>games" + games);
        Long count = repository.totalNumberofGames();
        System.out.println(">>>>>>count" + count);
        Bgg g = Utils.createBgg(games, limit, offset, count);

        JsonObject j = Utils.toJSON(g);
        System.out.println(">>>>>>JsonObject" + j);
        return j;
        
    }

    public JsonObject getGamesbyId(Integer id){
        List<Document> gamesbyId = repository.getGamebyId(id);
        System.out.println(">>>>> gamesbyId: " + gamesbyId);

        List<GameDetails> gd = gamesbyId.stream().map(v -> Utils.createGD(v)).toList();
        System.out.println(">>>>>>>gd"+ gd);

        List<JsonObject> j = gd.stream().map(v -> Utils.toJSON(v)).toList();
        System.out.println(j.get(0));
    
        return j.get(0);
    }
    
}
