import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../products.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-productslist',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './productslist.component.html',
  styleUrl: './productslist.component.css'
})
export class ProductslistComponent implements OnInit {
  products: any[] = [];

  constructor(private store: ProductsService) { }
  
  ngOnInit(): void {
    this.store.getAllProducts().subscribe((products: any[]) => {
      this.products = products;
    });
  }
}
