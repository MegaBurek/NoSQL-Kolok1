import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = `http://localhost:8080/user/`;

  constructor(private httpClient: HttpClient) { }

  getUsers() {
    return this.httpClient.get<User[]>(this.userUrl + `all`);
  }

  getUser(userID: number) {
    return this.httpClient.get<User>(this.userUrl + `${userID}`);
  }

  deleteUser(id: number) {
    return this.httpClient.delete<number>(this.userUrl + `${id}`);
  }

  addUser(user: User) {
    return this.httpClient.post<User>(this.userUrl + `add`, user);
  }
}
