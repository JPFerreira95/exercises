import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { WishItem } from '../shared/models/wishitem';
import { CommonModule } from '@angular/common';
import { EventService } from '../shared/services/EventService';
import { WishService } from './wish/wish.service';
import { WishModule } from './wish/wish.module';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, WishModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {

  items: WishItem[] = [];

  constructor(events: EventService, private wishService: WishService) {
    events.listen('removeWish', (wish: any) => {
      // todo remove wish from items
      let index = this.items.indexOf(wish);
      this.items.splice(index, 1);
    })
  }

  ngOnInit(): void {
    this.wishService.getWishes().subscribe((data: any) => {
      this.items = data;
    },
    (error : any) => {
      alert(error.message);
    });
  }

  filter: (item: WishItem) => boolean = () => true;

  // /**
  //  * This getter will trigger a change in the values in the DOM automatically whenever the visibleItems is changed
  //  */
  // get visibleItems(): WishItem[] {
  //   return this.items.filter(this.filter);
  // }

}
