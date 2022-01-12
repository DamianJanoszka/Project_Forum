import { Component, OnInit } from '@angular/core';
import { Post } from '../Post'
import { PostService } from '../post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  posts: Post[] = [];

  constructor(public postService: PostService) { }

    getPosts(): void {
      this.postService.getPosts().subscribe(posts => this.posts = posts);
      }

  ngOnInit(): void {
  }

}
