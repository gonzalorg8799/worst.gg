import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TiempoJugadoComponent } from './pages/tiempo-jugado/tiempo-jugado.component';
const routes: Routes = [
  {
    path: '',
    redirectTo: '/tiempoJugado',
    pathMatch: 'full'
  },
  {
    path: 'tiempoJugado',
    component: TiempoJugadoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
