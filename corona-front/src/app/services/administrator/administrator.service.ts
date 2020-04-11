import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Administrator } from 'src/app/model/administrator';

@Injectable({
  providedIn: 'root'
})
export class AdministratorService {

  private adminUrl = `http://localhost:8080/administrator/`;

  constructor(private httpClient: HttpClient) { }

  getUsers() {
    return this.httpClient.get<Administrator[]>(this.adminUrl + `all`);
  }

  getUser(adminID: number) {
    return this.httpClient.get<Administrator>(this.adminUrl + `${adminID}`);
  }

  deleteUser(id: number) {
    return this.httpClient.delete<number>(this.adminUrl + `${id}`);
  }

  addUser(admin: Administrator) {
    return this.httpClient.post<Administrator>(this.adminUrl + `add`, admin);
  }
}
