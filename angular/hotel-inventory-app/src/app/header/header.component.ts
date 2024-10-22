import { AfterViewInit, Component, OnInit } from '@angular/core';

@Component({
  selector: 'hinv-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit, AfterViewInit {

  title: string = '';

  constructor() {}

  ngOnInit(): void {}

  ngAfterViewInit(): void {
    console.log("After view is called");
  }

}
