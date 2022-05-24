import { Component, OnInit } from '@angular/core';
import {ProductsHttpService} from "../../../service/product/products-http-service.service";
import {Product} from "../../../models/Product";

@Component({
  selector: 'chx-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  allProducts: Product[] = [];

  constructor(private productHttpService: ProductsHttpService) { }

  ngOnInit(): void {
    this.productHttpService.getAllProducts()
      .subscribe(
        (products: Product[]) => this.allProducts = products
      );
  }
}
