import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TiempoJugadoComponent } from './tiempo-jugado.component';

describe('TiempoJugadoComponent', () => {
  let component: TiempoJugadoComponent;
  let fixture: ComponentFixture<TiempoJugadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TiempoJugadoComponent]
    });
    fixture = TestBed.createComponent(TiempoJugadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
