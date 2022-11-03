import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Customer} from "../model/customer";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  API_URL = 'http://localhost:8080/api/public/book';

  constructor(private http: HttpClient) {
  }

  getCustomer(username: string): Observable<Customer> {
    // @ts-ignore
    return this.http.post<Customer>(this.API_URL + '/' + username);
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.API_URL + `/user`);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.API_URL + '/customer/create', customer);
  }
}
