import {Injectable} from '@angular/core';
import {CartDetail} from "../model/cartDetail";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../model/book";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cart: CartDetail[] = [];

  constructor(private httpClient: HttpClient) {
  }
  addCard(book: Book, quantity: number) {
    let temp: CartDetail = {};
    if (JSON.parse(localStorage.getItem('cart')) !== null) {
      this.cart = JSON.parse(localStorage.getItem('cart'));
    }
    for (let i = 0; i < this.cart.length; i++) {
      if (this.cart[i].book.id === book.id) {
        temp = {
          book,
          quantity: quantity + this.cart[i].quantity
        };
        this.cart[i] = temp;
        if (temp.quantity === 0) {
          this.cart.splice(i, 1);
        }
        localStorage.setItem('cart', JSON.stringify(this.cart));
        return;
      }
    }
    temp = {
      book,
      quantity
    };
    this.cart.push(temp);
    localStorage.setItem('cart', JSON.stringify(this.cart));
  }
}
