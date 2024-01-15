import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { GameTimeService } from 'src/app/services/game-time.service';
@Component({
  selector: 'app-prueba-tiempo-jugado',
  templateUrl: './prueba-tiempo-jugado.component.html',
  styleUrls: ['./prueba-tiempo-jugado.component.sass']
})
export class PruebaTiempoJugadoComponent {
  timePlayed: string = "";
  constructor(
    private formBuilder: FormBuilder,
    private gameTimeService: GameTimeService
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
}
