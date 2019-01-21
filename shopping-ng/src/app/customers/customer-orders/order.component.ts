import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { ShoppingService } from '../shared/shopping.service';
import { LoggerService } from '../../core/logger.service';
import { Order } from '../shared/order';



@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  order: Observable<Order>;  
  constructor (
    private route: ActivatedRoute, 
    private router: Router,
    private logger: LoggerService, 
    private shoppingService: ShoppingService
  ) { }

  ngOnInit() {
    this.getSelectedOrder();
  }
  getSelectedOrder() {
    this.route.params.subscribe((params: Params) => {
      const id = params['id'];
      if (id) {
        this.order = this.shoppingService.getOrder(id);
      }
    });
  }

  viewCustomers() {
    this.route.params.subscribe((params: Params) => {
      const code = params['code'];
      if (code) {
        this.router.navigate(['/customers/', code]);
      }
    });
    
  }

}
