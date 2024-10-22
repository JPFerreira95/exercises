import { Component, OnInit } from '@angular/core';
import { WishItem } from '../../shared/models/wishitem';
import { CommonModule } from '@angular/common';
import { EventService } from '../../shared/services/EventService';
import { WishService } from './wish.service';
import { RouterOutlet } from '@angular/router';
import { AddWishFormComponent } from "./add-wish-form/add-wish-form.component";
import { WishFilterComponent } from "./wish-filter/wish-filter.component";
import { WishListComponent } from "./wish-list/wish-list.component";

@Component({
    selector: 'app-wish',
    standalone: true,
    templateUrl: './wish.component.html',
    styleUrl: './wish.component.css',
    imports: [RouterOutlet, CommonModule, AddWishFormComponent, WishFilterComponent, WishListComponent]
})
export class WishComponent implements OnInit {

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
