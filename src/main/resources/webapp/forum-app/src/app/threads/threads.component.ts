import { Component, OnInit } from '@angular/core';
import { Thread } from '../Thread'
import { ThreadService } from '../thread.service';

@Component({
  selector: 'app-threads',
  templateUrl: './threads.component.html',
  styleUrls: ['./threads.component.scss']
})
export class ThreadsComponent implements OnInit {

  threads: Thread[] = [];

  constructor(public threadService: ThreadService) { }

  getThreads(): void {
    this.threadService.getThreads().subscribe(threads => this.threads = threads);
    }

  ngOnInit(): void {
  }

}
