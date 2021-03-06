import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppConstants} from '../app-constants';
import {Observable} from 'rxjs';

@Injectable()
export class BookService {

  constructor(private http: HttpClient) {
  }

  getBooks(): Observable<any> {
    return this.http.get(AppConstants.API_URL + '/api/book');
  }

  getBook(id: any): Observable<any> {
    return this.http.get(AppConstants.API_URL + '/api/book/' + id);
  }

  getBookRatings(id: any): Observable<any> {
    return this.http.get(AppConstants.API_URL + '/api/book/' + id + '/ratings');
  }

  getBookRatingAverage(id: any): Observable<any> {
    return this.http.get(AppConstants.API_URL + '/api/book/' + id + '/ratings/average');
  }

  getNextBook(id: any): Observable<any> {
    return this.http.get(AppConstants.API_URL + '/api/book/' + id + '/next');
  }

  getPreviousBook(id: any): Observable<any> {
    return this.http.get(AppConstants.API_URL + '/api/book/' + id + '/previous');
  }

  saveRating(rating: any) : Observable<any>{
    return this.http.post(AppConstants.API_URL + '/api/rating', rating);
  }

}
