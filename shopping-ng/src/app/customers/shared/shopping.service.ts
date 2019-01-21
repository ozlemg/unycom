import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ShoppingService {
  private shoppingUrl = 'http://127.0.0.1:8080/api';

  constructor(private http: HttpClient) { 
  } 
  
  getCustomers(): Observable<any> {
    return this.http.get(`${this.shoppingUrl}/customers`).pipe(
      catchError(this.handleError)
    );
  }

  getCustomer(id): Observable<any> {
    return this.http.get(`${this.shoppingUrl}/customers/` + id).pipe(
      catchError(this.handleError)
    );
  }

  getOrder(id): Observable<any> {
    return this.http.get(`${this.shoppingUrl}/orders/` + id).pipe(
      catchError(this.handleError)
    );
  }

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error on client: ${error.error.message}`;
    } else {
      errorMessage = `Error from server... \nCode: ${error.status}\nMessage: ${error.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

}
