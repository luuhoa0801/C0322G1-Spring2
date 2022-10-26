import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CartDetail} from "../model/cartDetail";
import {Observable} from "rxjs";
import {History} from "../model/history";

@Injectable({
  providedIn: 'root'
})
export class CartDetailService {
  API_URL = 'http://localhost:8080/api/public/book';

  constructor(private httpClient: HttpClient) {
  }

  saveCartDetail(username: string, cartDetail: CartDetail[]) {
    return this.httpClient.post(this.API_URL + '/savecart/' + username, cartDetail);
  }

  getHistory(username: string): Observable<History> {
    return this.httpClient.get<History>(this.API_URL + '/history/' + username);

  }
}
