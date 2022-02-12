import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { LecturerCourses } from '../model/lecturer-courses.model';

@Injectable({
  providedIn: 'root'
})
export class LecturerCoursesService {

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Record<string,Object[]>> {
    const requestOptions: Object = {
      responseType: 'json'
    }
    return this.httpClient.get<Record<string,Object[]>>(environment.apiUrl + '/api/admin/find-all-map-with-lecturer-and-courses', requestOptions)
      .pipe(tap(_ => { console.log("dataGet") }),
        catchError(this.handleError<Record<string,Object[]>>('error')));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
