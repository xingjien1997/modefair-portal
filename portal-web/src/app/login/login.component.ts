import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'abc';
  password = '';
  invalidLogin = false;
  loginBy = "";

  constructor(private router: Router, private loginService: AuthenticationService) { }

  ngOnInit(): void {
  }

  checkLogin() {
    this.loginService.authenticate(this.username, this.password, this.loginBy).subscribe( res => {
      this.router.navigate(['']);
      this.invalidLogin = false;
      sessionStorage.setItem('studentId', res);
    });
  }
}
