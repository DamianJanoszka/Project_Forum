import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Board } from './Board';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BoardService {

  private url = 'http://localhost:4200/forum';

  constructor(private http: HttpClient) { }

    getBoards(): Observable<Board[]> {
      return this.http.get<Board[]>(`${this.url}`);
    }

    getThreads(): Observable<any> {
      return this.http.get(`${this.url}`);
    }
    // przerob przyklad z https://www.split.io/blog/crud-app-spring-boot-angular/
    addBoard(board: Board): Observable<Object> {
      return this.http.post(`${this.url}`, board);
    }

    deleteBoard(id: number): Observable<any> {
      return this.http.delete(`${this.url}/${id}`, {responseType: 'text'});
    }
}
