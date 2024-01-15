import { TestBed } from '@angular/core/testing';

import { GetPuuidService } from './get-puuid.service';

describe('GetPuuidService', () => {
  let service: GetPuuidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetPuuidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
