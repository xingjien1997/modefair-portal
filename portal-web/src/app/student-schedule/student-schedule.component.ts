import { Component, OnInit } from '@angular/core';
import { StudentSchedule } from '../model/student-schedule.model';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-student-schedule',
  templateUrl: './student-schedule.component.html',
  styleUrls: ['./student-schedule.component.css']
})
export class StudentScheduleComponent implements OnInit {

  constructor(private studentService: StudentService) { }

  studentSchedule?: StudentSchedule[];

  currentLoggedInId: any = '';

  ngOnInit(): void {
    this.currentLoggedInId = sessionStorage.getItem("studentId") !== null ? sessionStorage.getItem("studentId") : null;
    this.findStudentSchedulesByStudentId();
  }

  findStudentSchedulesByStudentId() {
    if (this.currentLoggedInId != null) {
      this.studentService.findStudentSchedulesByStudentId(this.currentLoggedInId).subscribe(res => {
        this.studentSchedule = res;
      });
    }
  }

}
