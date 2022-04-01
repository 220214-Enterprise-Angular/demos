import { TestBed } from '@angular/core/testing';

import { UserMockService } from './user-mock.service';

describe('UserMockService', () => {
  let service: UserMockService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserMockService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
