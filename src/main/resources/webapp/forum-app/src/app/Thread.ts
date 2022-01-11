import { Post } from './Post';
export class Thread {
  id!: number;
  title!: string;
  idAuthor!: number;
  idThread!: number;
  content!: string;
  idBoard!: number;
  postList!: Array<Post>;
  created!: Date;
  lastUpdated!: Date;
}
