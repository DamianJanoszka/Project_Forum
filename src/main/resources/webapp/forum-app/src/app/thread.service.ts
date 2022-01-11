import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Thread } from './Thread';

@Injectable({
  providedIn: 'root'
})
export class ThreadService {

  private url = 'http://localhost:8080/forum/thread/';

  constructor(private http: HttpClient) { }

    getThreads(): Observable<any> {
      return this.http.get(`${this.url}`);
    }

    addThread(thread: Thread): Observable<Object> {
      return this.http.post(`${this.url}`, thread);
    }

    deleteThread(id: number): Observable<any> {
      return this.http.delete(`${this.url}/${id}`, {responseType: 'text'});
    }
}
