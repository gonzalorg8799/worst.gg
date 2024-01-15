import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameTimeService {
  constructor(private httpClient: HttpClient) {}

  getTimePlayedService(tagLine: string, gameName: string): Observable<string> {
    return this.httpClient.get(`${environment.url}/worst/gameTime/${tagLine}/${gameName}`, { responseType: 'text' });
  }
}
