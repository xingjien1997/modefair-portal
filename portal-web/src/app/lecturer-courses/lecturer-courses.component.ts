import { Component, OnInit } from '@angular/core';
import { LecturerCourses } from '../model/lecturer-courses.model';
import { LecturerCoursesService } from '../service/lecturer-courses.service';

@Component({
  selector: 'app-lecturer-courses',
  templateUrl: './lecturer-courses.component.html',
  styleUrls: ['./lecturer-courses.component.css']
})
export class LecturerCoursesComponent implements OnInit {

  constructor(private lecturerCoursesService: LecturerCoursesService) { }
  
  lecturerCourses?: Object;
  
  listOfLecturer?: string[];
  listOfCourses!: string[];

  ngOnInit(): void {
    this.findAllLecturerWithCourses();
  }

  findAllLecturerWithCourses() {
    this.lecturerCoursesService.findAll().subscribe(res => {
      this.lecturerCourses = res;
      this.listOfLecturer = Object.keys(this.lecturerCourses);
      this.listOfCourses = Object.values(this.lecturerCourses);
      console.log(this.listOfCourses[0].length);
      console.log(Object.keys(this.lecturerCourses));
      console.log(Object.values(this.lecturerCourses));
      console.log(this.lecturerCourses);
      
    });
  }
}
