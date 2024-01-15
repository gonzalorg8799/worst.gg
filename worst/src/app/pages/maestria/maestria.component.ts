import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MasteryService } from 'src/app/services/mastery.service';

@Component({
  selector: 'app-maestria',
  templateUrl: './maestria.component.html',
  styleUrls: ['./maestria.component.sass']
})
export class MaestriaComponent {
  Maestria: string = ""
  constructor(
    private formBuilder: FormBuilder,
    private masteryService: MasteryService
  ){}
  form = this.formBuilder.nonNullable.group({
    gameName:['', [Validators.required]],
    tagLine: ['', [Validators.required]],
    championId:['', [Validators.required]]
  })
  doGetMastery(){
    if (this.form.valid){
      const {gameName, tagLine, championId} = this.form.getRawValue()
      this.masteryService.getMasteryService(gameName, tagLine, championId)
        .subscribe(
          (data: any) => {
            console.log('Respuesta del servidor:', data);
            this.Maestria = data;
          },
          (error) => {
            console.error('Error al obtener datos:', error);
          }
        );
    }
  }

}
