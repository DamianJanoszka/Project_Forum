import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class boardService? {

  private url = 'http://localhost:8080/forum/';

  constructor(private http: HttpClient) {
  }

  getBoards(): Observable<any> {
    return this.http.get(`${this.url}`);
  }

  getThreads(): Observable<any> {
    return this.http.get(`${this.url}`);
  }
  // przerob przyklad z https://www.split.io/blog/crud-app-spring-boot-angular/
 // addBook(book: Object): Observable<Object> {
//    return this.http.post(`${this.url}`, book);
//  }

  deleteBook(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`, {responseType: 'text'});
  }
}
