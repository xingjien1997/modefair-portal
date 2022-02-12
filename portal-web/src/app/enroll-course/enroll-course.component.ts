import { Component, OnInit } from '@angular/core';
import { Schedule, StudentSchedule } from '../model/student-schedule.model';
import { Student } from '../model/student.model';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-enroll-course',
  templateUrl: './enroll-course.component.html',
  styleUrls: ['./enroll-course.component.css']
})
export class EnrollCourseComponent implements OnInit {

  listOfStudent?: Student[];
  currentSelectedId!: number | -1;
  listOfStudentSchedules?: StudentSchedule[];
  listOfAvailableSchedules?: Schedule[];
  currentSelectedCourseScheduleIndex!: number | -1;

  studentName!: string;

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.findAllStudents();
  }

  findAllStudents() {
      this.studentService.findAll().subscribe( res => {
          this.listOfStudent = res;
          console.log(res);
      });
  }

  findStudentCurrentCourseAndSchedule(event: any) {
    console.log(event.target.selectedIndex);
    this.studentService.findStudentSchedulesByStudentId(event.target.selectedIndex).subscribe( res => {
        this.listOfStudentSchedules = res;
        console.log(res);
    });
  }

  findAvailableSchedulesByStudentId(index: number) {
    console.log(index)
    this.studentService.findAvailableSchedulesByStudentId(index).subscribe( res => {
        this.listOfAvailableSchedules = res;
        console.log(this.listOfAvailableSchedules);
        // this.currentSelectedId = event.target.selectedIndex;

    });
  }

  addCourseWithSchedule() {
    let scheduleId = this.currentSelectedCourseScheduleIndex;
    let studentId = this.currentSelectedId;
    let schedule = this.listOfAvailableSchedules!.find(x => x.id == scheduleId)!;
    let student = this.listOfStudent!.find(x => x.id == studentId)!;
    console.log(schedule);
    console.log(student);
    // const studentSchedule: StudentSchedule = new StudentSchedule(student, schedule);
    let studentSchedule: StudentSchedule = {
      student: student,
      schedule: schedule
    };
    this.studentService.saveSelectedSchedulesByStudentSchedule(studentSchedule).subscribe( res => {
      console.log(res);
    });

    console.log(this.currentSelectedCourseScheduleIndex);
    console.log(this.currentSelectedId);
  }

  createStudent() {
    if (this.studentName != undefined || this.studentName != null) {
        this.studentService.addNewStudent(this.studentName).subscribe(res => {
          console.log(res);
        })
    }
  }

}
