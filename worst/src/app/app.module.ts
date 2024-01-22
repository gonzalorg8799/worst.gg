import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TiempoJugadoComponent } from './pages/tiempo-jugado/tiempo-jugado.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaestriaComponent } from './pages/maestria/maestria.component';
@NgModule({
  declarations: [
    AppComponent,
    TiempoJugadoComponent,
    MaestriaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
