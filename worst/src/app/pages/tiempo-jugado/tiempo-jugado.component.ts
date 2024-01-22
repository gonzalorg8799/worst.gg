import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { GameTimeService } from 'src/app/services/game-time.service';
import { GameStadisticsService } from 'src/app/services/game-stadistics.service';
@Component({
  selector: 'app-tiempo-jugado',
  templateUrl: './tiempo-jugado.component.html',
  styleUrls: ['./tiempo-jugado.component.sass']
})
export class TiempoJugadoComponent {
  timePlayed: string = "";
  constructor(
    private formBuilder: FormBuilder,
    private gameTimeService: GameTimeService,
    private gameStadisticsService : GameStadisticsService
  ){ }
  form = this.formBuilder.nonNullable.group({
    tagLine: ['', [Validators.required]],
    gameName:['', [Validators.required]]
  })
  doGetTime(){
    if (this.form.valid){
      const {tagLine, gameName} = this.form.getRawValue()
      this.gameTimeService.getTimePlayedService(tagLine, gameName)
        .subscribe(
          (data: string) => {
            console.log('Respuesta del servidor:', data);
            this.timePlayed = data;
          },
          (error) => {
            console.error('Error al obtener datos:', error);
          }
        );
    }
  }
  doGetStatistics(){
    if (this.form.valid){
      const {tagLine, gameName} = this.form.getRawValue()
      this.gameStadisticsService.getStadisticsService(tagLine, gameName)
        .subscribe(
          (data: string) => {
            console.log('Respuesta del servidor:', data);
            this.timePlayed = data;
          },
          (error) => {
            console.error('Error al obtener datos:', error);
          }
        );
    }
  }
}
