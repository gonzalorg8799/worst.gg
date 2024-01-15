import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PruebaTiempoJugadoComponent } from './pages/prueba-tiempo-jugado/prueba-tiempo-jugado.component';
const routes: Routes = [
  {
    path: '',
    redirectTo: '/tiempoJugado',
    pathMatch: 'full'
  },
  {
    path: 'tiempoJugado',
    component: PruebaTiempoJugadoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
