import { TestBed } from '@angular/core/testing';

import { GameTimeService } from './game-time.service';

describe('GameTimeService', () => {
  let service: GameTimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GameTimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
