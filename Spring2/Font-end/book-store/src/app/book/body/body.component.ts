import { Component, OnInit } from '@angular/core';
import {Book} from "../../model/book";
import {BookService} from "../../service/book.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  bookList : Book[] = [];
  constructor(private bookService: BookService,
              private router: Router) { }

  ngOnInit(): void {
    this.bookService.getListBook().subscribe(value =>{
        this.bookList = value.content;
      console.log(this.bookList)
    },error => "lỗi")
  }

}
