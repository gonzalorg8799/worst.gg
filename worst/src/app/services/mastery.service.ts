import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class MasteryService {
  constructor(
    private httpClient : HttpClient
  ) { }
  getMasteryService(gameName: string, tagLine: string, championId: string){
    return this.httpClient.get(`${environment.url}/worst/campeon/${gameName}/${tagLine}/${championId}`, { responseType: 'text' });
  }
}
