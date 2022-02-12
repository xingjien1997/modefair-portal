import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Schedule, StudentSchedule } from '../model/student-schedule.model';
import { Student } from '../model/student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private httpClient: HttpClient) { }

  addNewStudent(studentName: string): Observable<string[]> {
    const requestOptions: Object = {
      responseType: 'text'
    }
    return this.httpClient.post<any>(environment.apiUrl + '/api/student/add-new-student', { studentName: studentName} ,requestOptions)
      .pipe(tap(_ => { console.log("dataGet") }),
        catchError(this.handleError<any>('error')));
  }

  findAll(): Observable<Student[]> {
    const requestOptions: Object = {
      responseType: 'json'
    }
    return this.httpClient.get<Student[]>(environment.apiUrl + '/api/student/find-all-students', requestOptions)
      .pipe(tap(_ => { console.log("dataGet") }),
        catchError(this.handleError<Student[]>('error')));
  }

  findStudentSchedulesByStudentId(studentId: number): Observable<StudentSchedule[]> {
    const requestOptions: Object = {
      responseType: 'json'
    }
    return this.httpClient.get<StudentSchedule[]>(environment.apiUrl + '/api/student/find-student-schedules-by-student-id/' + studentId , requestOptions)
      .pipe(tap(_ => { console.log("dataGet") }),
        catchError(this.handleError<StudentSchedule[]>('error')));
  }

  findAvailableSchedulesByStudentId(studentId: number): Observable<Schedule[]> {
    const requestOptions: Object = {
      responseType: 'json'
    }
    return this.httpClient.get<Schedule[]>(environment.apiUrl + '/api/schedule/find-available-schedules-by-student-id/' + studentId , requestOptions)
      .pipe(tap(_ => { console.log("dataGet") }),
        catchError(this.handleError<Schedule[]>('error')));
  }

  saveSelectedSchedulesByStudentIdAndScheduleId(studentId: number, scheduleId: number): Observable<string> {
    const requestOptions: Object = {
      responseType: 'text'
    }
    return this.httpClient.post<string>(environment.apiUrl + '/api/schedule/add-new-schedule-by-student-id-and-schedule-id', { studentId: studentId, scheduleId: scheduleId }, requestOptions)
      .pipe(tap(_ => { console.log("dataGet") }),
        catchError(this.handleError<string>('error')));
  }

  saveSelectedSchedulesByStudentSchedule(studentSchedule: StudentSchedule): Observable<string> {
    const requestOptions: Object = {
      responseType: 'json'
    }
    console.log(studentSchedule);
    return this.httpClient.post<string>(environment.apiUrl + '/api/schedule/add-new-schedule-by-student-id-and-schedule-id', studentSchedule, requestOptions)
      .pipe(tap(_ => { console.log("dataGet") }),
        catchError(this.handleError<string>('error')));
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
