import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  

  constructor(private httpClient: HttpClient) { }

  authenticate(username: string, password: string, loginBy: string):Observable<string> {
    const requestOptions: Object = {
      responseType: 'text'
    }

    if (loginBy == 'admin') {
      return this.httpClient.post<string>(environment.apiUrl + '/api/admin/login', { username: username, password: password }, requestOptions)
      .pipe(tap(_ => { sessionStorage.setItem('admin',username) }),
        catchError(this.handleError<string>('error')));
    } else {
      return this.httpClient.post<string>(environment.apiUrl + '/api/student/login', { username: username, password: password }, requestOptions)
      .pipe(tap(_ => { sessionStorage.setItem('student',username) }),
        catchError(this.handleError<string>('error')));
    }
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); 
      return of(result as T);
    };
  }

  isAdminLoggedIn() {
    let user = sessionStorage.getItem('admin');
    return !(user === null);
  }

  isStudentLoggedIn() {
    let user = sessionStorage.getItem('student');
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('student');
    sessionStorage.removeItem('admin');
  }
}

