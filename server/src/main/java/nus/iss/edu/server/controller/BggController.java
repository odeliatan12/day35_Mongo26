package nus.iss.edu.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.JsonObject;
import nus.iss.edu.server.service.BggService;

@Controller
@CrossOrigin(origins = "*")
public class BggController {

    @Autowired
    private BggService service;

    @GetMapping("/games")
    @ResponseBody()
    public ResponseEntity<String> getAllGames(@RequestParam String limit, @RequestParam String offset){

        Integer L1 = Integer.parseInt(limit);
        Integer S1 = Integer.parseInt(offset);
        JsonObject json = service.getGames(L1, S1);
        System.out.println(json.toString());
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
        
    }

    @GetMapping("/games/{id}")
    @ResponseBody()
    public ResponseEntity<String> getGamesbyId(@PathVariable("id") Integer id){
        JsonObject j = service.getGamesbyId(id);
        return ResponseEntity.status(HttpStatus.OK).body(j.toString());
    }
    
}
