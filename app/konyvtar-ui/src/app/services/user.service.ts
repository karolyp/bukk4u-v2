import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppConstants} from '../app-constants';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  saveUser(user: any) {
    return this.http.post(AppConstants.API_URL + '/user', user);
  }

  loginUser(user: any) {
    return this.http.post(AppConstants.API_URL + '/login', user);
  }

  isLoggedIn() {
    return localStorage.getItem('token') !== null;
  }

}
