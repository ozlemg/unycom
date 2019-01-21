import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { OrderComponent } from './customer-orders/order.component';

const routes: Routes = [
  {
    path: '',
    component: CustomerListComponent, 
  },
  { 
    path: ':code', 
    component: CustomerComponent
  }, 
  { 
    path: 'order/:code/:id', 
    component: OrderComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomersRoutingModule { 
  static components = [ CustomerListComponent, CustomerComponent, OrderComponent ];
}
