import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GetPuuidService {
  constructor(
    private httpClient : HttpClient
  ) { }
  getPuuidService(tagLine: string, gameName: string){
    this.httpClient.get(`${environment}/worst/gameTime`,{
      params :{
        tagLine,
        gameName
      }
    })
  }
}
