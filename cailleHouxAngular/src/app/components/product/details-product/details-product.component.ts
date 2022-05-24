import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {map, Observable, of, switchMap} from "rxjs";
import {ProductsHttpService} from "../../../service/product/products-http-service.service";
import {Product} from "../../../models/Product";

@Component({
  selector: 'chx-details-product',
  templateUrl: './details-product.component.html',
  styleUrls: ['./details-product.component.scss']
})
export class DetailsProductComponent implements OnInit {
  private productId: number = 0;
  targetProduct: Product | null = null;

  constructor(private route: ActivatedRoute, private productService: ProductsHttpService) {
  }

  ngOnInit(): void {
    this.loadData().subscribe();
    console.log(this.targetProduct);
  }

  loadData(): Observable<Product> {
    return this.route.paramMap.pipe(
      switchMap((params: Params) => {
        this.productId = params['get']('id');
       return this.productService.getProductById(this.productId).pipe(map((product: Product) => this.targetProduct = product));
      }))
  }
}
