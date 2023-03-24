import { HttpParams } from '@angular/common/http';
import { Component, OnInit, Output } from '@angular/core';
import { Subject } from 'rxjs';
import { Bgg, Games, GamesDetails } from 'src/app/models';
import { GamesService } from './games.service';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})
export class GamesComponent implements OnInit {

  Bgg!: Bgg

  gameDetails!: GamesDetails

  @Output()
  onNewGame = new Subject<GamesDetails>()

  constructor(private gameSvc: GamesService){ }

  ngOnInit(): void {

    this.getAllGames()
      .then(result => {
        console.log(result)
        return this.Bgg = result as Bgg
      });
      
  }

  getAllGames(): Promise<Bgg>{
    console.log(">>>>> hello world")
    const params = new HttpParams().set("limit", 25).set("offset", 0)
    console.log(params)
    return this.gameSvc.getAllGames(params)
  }

  getGamesbyId(id: Games["game_id"]): Promise<GamesDetails>{
    return this.gameSvc.getGamesbyId(id)
        .then(result => {
          console.log(result)
          const gameDetail = result as GamesDetails
          this.onNewGame.next(gameDetail)
          return this.gameDetails = gameDetail
        })
  }

}
