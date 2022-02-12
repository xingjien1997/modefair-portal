import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EnrollCourseComponent } from './enroll-course/enroll-course.component';
import { LecturerCoursesComponent } from './lecturer-courses/lecturer-courses.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { StudentScheduleComponent } from './student-schedule/student-schedule.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'view/lecturer/courses', component: LecturerCoursesComponent },
  { path: 'enroll/course', component: EnrollCourseComponent },
  { path: 'view/student/schedule', component: StudentScheduleComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
