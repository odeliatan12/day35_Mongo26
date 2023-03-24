package nus.iss.edu.server.repo;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static nus.iss.edu.server.Constants.*;

@Repository
public class BggRepoImpl {

    @Autowired
    private MongoTemplate template;

    // Get Games with limit of 25 and skip 0
    public List<Document> getGamesDefault(){
        return getGames(25, 0);
    }

    // Get all Games
    public List<Document> getGames(Integer limit, Integer skip){

        Query query = Query.query(Criteria.where(FIELD_GID).exists(true)).limit(limit).skip(skip);

        System.out.println(">>>>> getGames" + query);
        return template.find(query, Document.class, COLLECTION_GAMES);

    }

    // Get Total number of Games
    public Long totalNumberofGames(){

        Query query = Query.query(Criteria.where(FIELD_GID).exists(true));
        Long count = template.count(query, COLLECTION_GAMES);

        System.out.println(">>>>>> count" + query);
        return count;
    }

    // Get details of each game
    public List<Document> getGamebyId(Integer id){

        Query query = Query.query(Criteria.where(FIELD_GID).is(id));

        System.out.println(">>>>> gamebyId" + query);
        return template.find(query, Document.class, COLLECTION_GAMES);

    }
    
}
