import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WishItem } from '../../../shared/models/wishitem';
import { EventService } from '../../../shared/services/EventService';

@Component({
  selector: 'wish-list-item',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './wish-list-item.component.html',
  styleUrl: './wish-list-item.component.css',
})
export class WishListItemComponent {
  @Input() wish!: WishItem;

  get cssClasses() {
    // return this.fulfilled ? ['strikeout', 'text-muted'] : [];

    return { 'strikeout text-muted': this.wish.isComplete };
  }

  constructor(private events: EventService) { }

  toggleFulfilled() {
    this.wish.isComplete = !this.wish.isComplete;
  }

  removeWish() {
    this.events.emit('removeWish', this.wish);
  }

}
