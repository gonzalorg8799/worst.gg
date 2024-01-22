import { TestBed } from '@angular/core/testing';

import { GameStadisticsService } from './game-stadistics.service';

describe('GameStadisticsService', () => {
  let service: GameStadisticsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GameStadisticsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
