import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { Bgg } from "src/app/models";

@Injectable()
export class GamesService{

    constructor(private http: HttpClient){ }

    getAllGames(params: HttpParams): Promise<Bgg> {
        return firstValueFrom(
            this.http.get<Bgg>("http://localhost:8080/games", { params: params })
        )
    }
    
    getGamesbyId(gamesId: number): Promise<any> {
        return firstValueFrom(
            this.http.get<any>(`http://localhost:8080/games/${gamesId}`)
        )
    }
}