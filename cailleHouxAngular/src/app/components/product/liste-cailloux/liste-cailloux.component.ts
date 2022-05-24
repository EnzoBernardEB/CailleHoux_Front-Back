import { Component, OnInit } from '@angular/core';
import {ProductsHttpService} from "../../../service/product/products-http-service.service";
import {Product} from "../../../models/Product";

@Component({
  selector: 'chx-liste-cailloux',
  templateUrl: './liste-cailloux.component.html',
  styleUrls: ['./liste-cailloux.component.scss']
})
export class ListeCaillouxComponent implements OnInit {
  allProducts: Product[] = [];

  constructor(private productHttpService: ProductsHttpService) { }

  ngOnInit(): void {
    this.productHttpService.getAllProducts()
      .subscribe(
        (products: Product[]) => this.allProducts = products
    );
  }

}
