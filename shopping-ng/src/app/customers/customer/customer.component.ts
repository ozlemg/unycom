import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';

import { Customer } from '../shared/customer';
import { ShoppingService } from '../shared/shopping.service';
import { LoggerService } from '../../core/logger.service';
import { CustomerType } from '../shared/custumer-type';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: Observable<Customer>;  
  code: string;
  vipCustomer: CustomerType;
  displayedColumns: string[];
  constructor (
    private route: ActivatedRoute, 
    private logger: LoggerService, 
    private shoppingService: ShoppingService
  ) { }

  ngOnInit() {
    this.getSelectedCustomer();
    this.vipCustomer = CustomerType.VIP;
    this.fillColumns();
  }
  getSelectedCustomer() {
    this.route.params.subscribe((params: Params) => {
      this.code = params['code'];
      if (this.code) {
        this.customer = this.shoppingService.getCustomer(this.code);
      }
    });
  }

  fillColumns() {
    this.displayedColumns = ["Id", "Order Date", "Confirmation Date", "Completion Date", "Product", "Original Price", "Final Price", "Status"];
  }
}
