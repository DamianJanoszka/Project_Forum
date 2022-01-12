import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Post } from './Post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url = 'http://localhost:4200/forum/thread';

  constructor(private http: HttpClient) { }

    getPosts(): Observable<Post[]> {
      return this.http.get<Post[]>(`${this.url}`);
    }
    addPost(post: Post): Observable<Object> {
      return this.http.post(`${this.url}`, post);
    }

    deletePost(id: number): Observable<any> {
      return this.http.delete(`${this.url}/${id}`, {responseType: 'text'});
    }
}
