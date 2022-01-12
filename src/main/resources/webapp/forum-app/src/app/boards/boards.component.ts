import { Component, OnInit } from '@angular/core';
import { Board } from '../Board'
import { BoardService } from '../board.service';


@Component({
  selector: 'app-boards',
  templateUrl: './boards.component.html',
  styleUrls: ['./boards.component.scss']
})
export class BoardsComponent implements OnInit {

  boards: Board[] = [];

  constructor(public boardService: BoardService) { }

  getBoards(): void {
    this.boardService.getBoards().subscribe(boards => this.boards = boards);
    }
  ngOnInit(): void {
  }

}
