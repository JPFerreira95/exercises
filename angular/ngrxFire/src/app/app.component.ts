import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Action, Store } from "@ngrx/store";
import { Observable } from 'rxjs';
import { Post } from './redux/models/post.model';
import * as PostActions from './redux/actions/post.actions';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface AppState {
  message: String;
  post: Post;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  title = 'ngrxFire'

  message$: Observable<String>;

  post: Observable<Post>;
  text: string = "Default Post" // from input val

  constructor(private store: Store<AppState>) {
    this.message$ = this.store.select('message');
    this.post = this.store.select('post');
  }

  spanishMessage() {
    this.store.dispatch({type: 'SPANISH'})
  }

  frenchMessage() {
    this.store.dispatch({type: 'FRENCH'})
  }

  editText() {
    this.store.dispatch(new PostActions.EditText(this.text))
  }

  resetPost() {
    this.store.dispatch(new PostActions.Reset())
  }

  upvotePost() {
    this.store.dispatch(new PostActions.Upvote())
  }

  downvotePost() {
    this.store.dispatch(new PostActions.Downvote())
  }

}
