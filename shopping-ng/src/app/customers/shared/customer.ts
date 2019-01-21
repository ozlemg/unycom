import { CustomerType } from './custumer-type';
import { Order } from './order';

export class Customer {
    code: string;
    name: string;
    location: string;
    registrationDate: Date;
    type: CustomerType;
    orders?: Array<Order>;
    active?: boolean;
}