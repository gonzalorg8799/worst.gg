import { TestBed } from '@angular/core/testing';

import { MasteryService } from './mastery.service';

describe('MasteryService', () => {
  let service: MasteryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MasteryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
