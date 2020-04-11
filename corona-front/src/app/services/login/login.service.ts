import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  roleChanged = new Subject<any[]>();
  loggedInStatusChanged = new Subject<boolean>();


  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  login(username: string, password: string){
    this.http.post<{ accessToken: string }>('http://localhost:8080/login', { username: username, password: password }).subscribe(response => {
      if (response.accessToken) {
        localStorage.setItem('accessToken', response.accessToken);
        this.roleChanged.next(this.getCurrentRoles());
        this.loggedInStatusChanged.next(true);
        this.router.navigate(['/home'])
      }
    });
  }

  logout() {
    this.roleChanged.next([]);
    localStorage.removeItem('accessToken');
    this.router.navigate(['/login']);
    this.loggedInStatusChanged.next(false);
  }

  getCurrentRoles() {
    const accessToken = localStorage.getItem('accessToken');
    const roles = []
    if (accessToken) {
      decode(accessToken).role.forEach(role => {
        roles.push(role.authority);
      });
    }
    return roles;
  }

  getCurrentUser() {
    const accessToken = localStorage.getItem('accessToken');
    if (accessToken) {
      return decode(accessToken).uniq;
    }
    return null;
  }

  isLoggedIn() {
    if (localStorage.getItem('accessToken')) {
      return true;
    }
    return false;
  }




}
