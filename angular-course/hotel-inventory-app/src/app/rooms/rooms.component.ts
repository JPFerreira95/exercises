import { Component } from '@angular/core';

@Component({
  selector: 'hinv-rooms',
  standalone: true,
  imports: [],
  templateUrl: './rooms.component.html',
  styleUrl: './rooms.component.scss'
})
export class RoomsComponent {

  hotelName = 'Hilton hotel';
  numberOfRooms = 10;
  hideRooms = false;

  toggle() {
    this.hideRooms = !this.hideRooms;
  }
}
