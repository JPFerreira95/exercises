import { Component, Input } from '@angular/core';
import { HousingLocation } from '../../interfaces/housing-location/housingLocation';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-housing-location',
  standalone: true,
  imports: [RouterLink, RouterOutlet],
  templateUrl: './housing-location.component.html',
  styleUrl: './housing-location.component.css'
})
export class HousingLocationComponent {

  /*
   * required value
   * 
   * The exclamation point is called the non-null assertion operator and it tells the TypeScript compiler 
   * that the value of this property won't be null or undefined.
   */
  @Input() housingLocation!: HousingLocation;

}
