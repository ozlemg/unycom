import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Customer } from '../shared/customer';
import { ShoppingService } from '../shared/shopping.service';
import { LoggerService } from '../../core/logger.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})

export class CustomerListComponent implements OnInit {

  displayedColumns: string[];
  customers: Observable<Customer[]>;

  constructor
  (
    private logger: LoggerService,
    private shoppingService: ShoppingService
  ) { }

    ngOnInit() {
      this.fillColumns();
      this.getCustomers();
    }

    getCustomers() {
      this.customers = this.shoppingService.getCustomers();
    }

    getCustomer(code: string) {
      return this.customers.pipe(
        map(customers => customers.find(customer => customer.code === code))
      );
    }

    fillColumns() {
      this.displayedColumns = ["Name", "Location", "Registration Date", "Type", "Is Active"];
    }
}