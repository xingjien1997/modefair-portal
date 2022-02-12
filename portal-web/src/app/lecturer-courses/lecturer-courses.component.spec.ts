import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LecturerCoursesComponent } from './lecturer-courses.component';

describe('LecturerCoursesComponent', () => {
  let component: LecturerCoursesComponent;
  let fixture: ComponentFixture<LecturerCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LecturerCoursesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LecturerCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
