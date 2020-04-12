import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
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
  public loggedUserType: String;
  private loggedInSubcription: Subscription;
  roles = [];
  private roleSubcription: Subscription;


  constructor(
    private loginService: LoginService
  ) {
  }

  ngOnInit() {
    this.standardLogin();
   }
   
   standardLogin() {
    this.loggedInSubcription = this.loginService.loggedInStatusChanged.subscribe(
      (status: boolean) => {
        this.isLoggedIn = status;
      }
    );

    this.loggedUserRoles = this.loginService.getCurrentRoles();
    this.loggedUserRoles.forEach(role => {
      if (role === 'ROLE_ADMINISTRATOR') {
        this.loggedUserType = 'administrator';
        this.adminLoggedIn = true;
      }
      if (role === 'ROLE_USER') {
        this.loggedUserType = 'user';
      }
    });

  }

  onLogout() {
    this.loginService.logout();
  }

  ngOnDestroy() {
    this.loggedInSubcription.unsubscribe();
    this.roleSubcription.unsubscribe();
  }


}
