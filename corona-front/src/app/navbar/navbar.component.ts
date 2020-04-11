import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {


  isLoggedIn = false;
  adminLoggedIn = false;
  private loggedUserRoles: String[];
  private loggedUserRole: String;

  constructor(
    private loginService: LoginService
  ) {
  }

  ngOnInit(): void {
    this.standardLogin();
  }

  standardLogin() {
    this.isLoggedIn = this.loginService.isLoggedIn();
    this.loggedUserRoles = this.loginService.getCurrentRoles();
    this.loggedUserRoles.forEach(role => {
      if (role === 'ROLE_ADMINISTRATOR') {
        this.loggedUserRole = 'administrator';
        this.adminLoggedIn = true;
      }
      if (role === 'ROLE_USER') {
        this.loggedUserRole = 'user';
      }
    });

  }


}
