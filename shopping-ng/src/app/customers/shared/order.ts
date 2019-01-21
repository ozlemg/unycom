import { OrderStatus } from './order-status';
import { Customer } from './customer';

export class Order {
    id: number;
    orderDate: Date;
    confirmDate: Date;
    completeDate: Date;
    product: string;
    originalPrice: number;
    finalPrice: number;
    status: OrderStatus;
    customer: Customer;
}