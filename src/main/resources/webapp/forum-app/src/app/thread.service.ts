import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Thread } from './Thread';

@Injectable({
  providedIn: 'root'
})
export class ThreadService {

  private url = 'http://localhost:4200/forum/board/';

  constructor(private http: HttpClient) { }

    getThreads(): Observable<Thread[]> {
      return this.http.get<Thread[]>(`${this.url}`);
    }

    addThread(thread: Thread): Observable<Object> {
      return this.http.post(`${this.url}`, thread);
    }

    deleteThread(id: number): Observable<any> {
      return this.http.delete(`${this.url}/${id}`, {responseType: 'text'});
    }
}
