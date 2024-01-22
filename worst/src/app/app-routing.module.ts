import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TiempoJugadoComponent } from './pages/tiempo-jugado/tiempo-jugado.component';
import { MaestriaComponent } from './pages/maestria/maestria.component';
const routes: Routes = [
  {
    path: '',
    redirectTo: '/tiempoJugado',
    pathMatch: 'full'
  },
  {
    path: 'tiempoJugado',
    component: TiempoJugadoComponent
  },
  {
    path: 'maestria',
    component: MaestriaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
