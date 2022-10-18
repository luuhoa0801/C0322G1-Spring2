import { Component, OnInit } from '@angular/core';
import {CartDetail} from "../model/cartDetail";
import {CartDetailService} from "../service/cart-detail.service";
import {Book} from "../model/book";
import {CartService} from "../service/cart.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartDetail : CartDetail[]=[];
  totalCart = 0;
  money = 10000;


  constructor(private cartService : CartService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.cartDetail = JSON.parse(localStorage.getItem('cart'));
    this.resultTotal();
  }
  decCard(item: Book) {
    this.cartService.addCard(item, -1);
    this.getAll();
  }
  incCard(item: Book) {
    this.cartService.addCard(item, 1);
    this.getAll();
  }
  resultTotal() {
    let temp = 0;
    if (this.cartDetail === null || this.cartDetail.length === 0) {
      temp = 0;
    } else {
      for (const item of this.cartDetail) {
        temp += item.book.price * item.quantity;
      }
    }
    this.totalCart = temp;
  }

  deletedCart(index: number) {
    // tslint:disable-next-line:variable-name
    Swal.fire({
      title: 'Thông Báo !',
      text: 'Bạn Muốn Xoá Sản Phẩm Này Khỏi Giỏ Hàng ?!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Đồng Ý'
    }).then((result: any) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Thông Báo !',
          'Đã Xoá Sản Phẩm Khỏi Giỏ Hàng.',
          'success'
        );

      }
    });
  }
  deleteCart(id: number) {
    for (const card of this.cartDetail) {
      if (card.book.id === id) {
        Swal.fire({
          title: 'Thông Báo !',
          text: 'Bạn Muốn Xoá Sản Phẩm Này Khỏi Giỏ Hàng ?!',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Đồng Ý'
        }).then((result: any) => {
          if (result.isConfirmed) {
            Swal.fire(
              'Thông Báo !',
              'Đã Xoá Sản Phẩm Khỏi Giỏ Hàng.',
              'success'
            );
            this.cartDetail.splice(this.cartDetail.indexOf(card), 1);
            localStorage.setItem('cart', JSON.stringify(this.cartDetail));
            return;
          }
        });

      }
    }
  }
}
