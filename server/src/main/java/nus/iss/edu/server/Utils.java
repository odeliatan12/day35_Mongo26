package nus.iss.edu.server;

import java.util.List;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import nus.iss.edu.server.models.Bgg;
import nus.iss.edu.server.models.GameDetails;
import nus.iss.edu.server.models.Games;

public class Utils {


    public static JsonObjectBuilder toJSON(Games g){
        return Json.createObjectBuilder()
                    .add("game_id", g.getGame_id())
                    .add("name", g.getName());
                    
    }

    public static JsonObject toJSON(Bgg bgg){
        
        JsonArrayBuilder arrBuild = Json.createArrayBuilder();
        List<JsonObjectBuilder> gameList = bgg.getGameList()
            .stream()
            .map(v -> toJSON(v))
            .toList();
        
        for (JsonObjectBuilder x : gameList){
            arrBuild.add(x);
        }

        return Json.createObjectBuilder()
            .add("games", arrBuild)
            .add("offset", bgg.getOffset())
            .add("limit", bgg.getLimit())
            .add("total", bgg.getTotal())
            .build();
    }

    public static Games createGames(Document d){
        Games g = new Games();
        g.setGame_id(d.getInteger("gid"));
        g.setName(d.getString("name"));
        return g;
    }

    public static Bgg createBgg(List<Document> d, Integer limit, Integer offset, Long count){

        Bgg bgg = new Bgg();
        System.out.println(d);
        List<Games> g = d.stream().map(v -> createGames(v)).toList();
        System.out.println(g);
        System.out.println(">>>>>> gameList");
        bgg.setGameList(g);
        bgg.setOffset(offset);
        bgg.setLimit(limit);
        bgg.setTotal(count);
        return bgg;
    }

    public static GameDetails createGD(Document d){
        GameDetails gd = new GameDetails();
        gd.setGame_id(d.getInteger("gid"));
        gd.setName(d.getString("name"));
        gd.setYear(d.getInteger("year"));
        gd.setRanking(d.getInteger("ranking"));
        gd.setUsers_rated(d.getInteger("users_rated"));
        gd.setUrl(d.getString("url"));
        gd.setImage(d.getString("image"));
        return gd;
    }

    public static JsonObject toJSON(GameDetails gd){
        return Json.createObjectBuilder()
                    .add("game_id", gd.getGame_id())
                    .add("name", gd.getName())
                    .add("year", gd.getYear())
                    .add("ranking", gd.getRanking())
                    .add("users_rated", gd.getUsers_rated())
                    .add("url", gd.getUrl())
                    .add("image", gd.getImage())
                    .build();
    }

    
}
