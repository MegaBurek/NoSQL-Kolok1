import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { RegisterService } from '../services/register/register.service';
import { User } from '../model/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  fullname = '';
  email = '';
  password = '';
  isLoadingResults = false;

  user: User = {
    id: null,
    name: '',
    surname: '',
    accountData: {
      id: null,
      username: '',
      password: '',
      permission: {
        id: null,
        authority: null
      }
    }
  };

  

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private registerService: RegisterService
  ) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      'username' : [null, Validators.required],
      'password' : [null, Validators.required],
      'name' : [null, Validators.required],
      'surname' : [null, Validators.required]
    });
  }

  onFormSubmit() {
    this.user.name = this.registerForm.controls.name.value;
    this.user.surname = this.registerForm.controls.surname.value;
    this.user.accountData.username = this.registerForm.controls.username.value;
    this.user.accountData.password = this.registerForm.controls.password.value;
    this.registerService.register(this.user)
      .subscribe(res => {
        alert('You have succesfully registered')
        this.router.navigate(['login']);
      }, (err) => {
        console.log(err);
        alert(err.error);
      });
  }
  

  

  // getAllUsernams() {
  //   this.authService.getAllEmails().subscribe((data: string[]) => {
  //     this.emails = data;
  //     console.log(this.emails);
  //   });
  // }




}
