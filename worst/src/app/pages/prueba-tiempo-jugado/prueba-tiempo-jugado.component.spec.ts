import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PruebaTiempoJugadoComponent } from './prueba-tiempo-jugado.component';

describe('PruebaTiempoJugadoComponent', () => {
  let component: PruebaTiempoJugadoComponent;
  let fixture: ComponentFixture<PruebaTiempoJugadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PruebaTiempoJugadoComponent]
    });
    fixture = TestBed.createComponent(PruebaTiempoJugadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
