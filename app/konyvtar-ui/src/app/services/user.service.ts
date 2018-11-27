import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {AppConstants} from '../app-constants';
import {parseErrorsFromMarkup} from 'tslint/lib/verify/parse';
import {Observable} from 'rxjs';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  saveUser(user: any) {
    return this.http.post(AppConstants.API_URL + '/api//user', user);
  }

  loginUser(user: any) {
    return this.http.post(AppConstants.API_URL + '/api/login', user);
  }

  getUser(username: any): Observable<any> {
    let token = JSON.parse(localStorage.getItem('token'));
    if (token !== null) {
      token = token.tokenUuid;
    }
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Authorization': token
    });
    return this.http.get(AppConstants.API_URL + '/api/user?username=' + username, {
      headers: headers,
    });
  }

  isLoggedIn() {
    return localStorage.getItem('token') !== null;
  }

}
