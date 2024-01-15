import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class GameStadisticsService {
  constructor(
    private httpClient : HttpClient
  ) { }
    getGameStadisticsService(tagLine: string, gameName: string){
      this.httpClient.get(`${environment.url}/worst/gameTime`)
    }
}
