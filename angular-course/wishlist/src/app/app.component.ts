import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { WishItem } from '../shared/models/wishitem';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  items = [
    new WishItem('To Learn Angular'),
    new WishItem('Get coffee', true),
    new WishItem('Find grass that cuts itself')
  ]
  title = 'My Wishlist';

}
