import { Component, Output, EventEmitter, OnInit, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WishItem } from '../../../shared/models/wishitem';

const filters = [
  (item: WishItem) => item,
  (item: WishItem) => !item.isComplete,
  (item: WishItem) => item.isComplete
]

@Component({
  selector: 'wish-filter',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './wish-filter.component.html',
  styleUrl: './wish-filter.component.css'
})
export class WishFilterComponent implements OnInit {

  // By namming the Output with the suffix "Change", angular knows that this is a two way binding with the input
  @Input() filter: any;
  @Output() filterChange = new EventEmitter<any>();

  constructor() {
  }

  ngOnInit(): void {
    this.updateFilter('0');
  }

  // Default value to the dropdown list
  listFilter: any = '0';

  updateFilter(value : any) {
    this.filter = filters[value];
    this.filterChange.emit(this.filter);
  }

}
