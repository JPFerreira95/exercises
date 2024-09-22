import { Component, Output, EventEmitter, OnInit } from '@angular/core';
import { WishItem } from '../../../shared/models/wishitem';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'add-wish-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-wish-form.component.html',
  styleUrl: './add-wish-form.component.css',
})
export class AddWishFormComponent {
  @Output() addWish = new EventEmitter<WishItem>();

  constructor() {}

  newWishText: string = '';

  /**
   * Add wish to items array
   * Clears the text box
   */
  addNewWish() {
    //this.items.push(new WishItem(this.newWishText));
    this.addWish.emit(new WishItem(this.newWishText));
    this.newWishText = '';
  }
}
