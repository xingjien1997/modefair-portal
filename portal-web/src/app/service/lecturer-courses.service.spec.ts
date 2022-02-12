import { TestBed } from '@angular/core/testing';

import { LecturerCoursesService } from './lecturer-courses.service';

describe('LecturerCoursesService', () => {
  let service: LecturerCoursesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LecturerCoursesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
