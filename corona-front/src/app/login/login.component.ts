import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  // badAttempt = false;

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private router: Router

  ) {
    // redirect to home if already logged in 
    // if (this.loginService.loggedInStatusChanged) {
    //   this.router.navigate(['/home'])
    // }
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  async login() {
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    await this.loginService.login(this.f.username.value, this.f.password.value)
  }

  logout() {
    // this.loginService.logout();
  }

}
