import { Component, OnInit } from '@angular/core';
import {Book} from "../../model/book";
import {Category} from "../../model/category";
import {BookService} from "../../service/book.service";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  books: Book[] = [];

  categories: Category[] = [];

  id: number;
  code: string;
  name: string;
  price: number;
  discount:number;
  author: string;
  description: string;
  dimension: string;
  translator: string;
  publishingHome:string;
  img: string;
  quantity: number;
  totalPage:number;
  releaseDate?:string;

  constructor(private bookService:BookService,
              private categoryService: CategoryService,
              private activatedRoute : ActivatedRoute,
              private title : Title) {
    this.title.setTitle('Chi Tiết Sách');
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getDetail(this.id);
      console.log(this.id);
    });
  }

  ngOnInit(): void {
    this.getCategory();
  }
  getDetail(id: number) {
    return this.bookService.findById(id).subscribe(book => {
      this.id = book.id;
      this.code = book.code;
      this.name = book.name;
      this.price = book.price;
      this.discount = book.discount;
      this.author = book.author;
      this.description = book.description;
      this.dimension = book.dimension;
      this.translator = book.translator;
      this.publishingHome = book.publishingHome;
      this.img = book.img;
      this.quantity = book.quantity;
      this.totalPage = book.totalPage;
      this.releaseDate = book.releaseDate;
      console.log(book);
    });
  }
  getAll() {
    this.bookService.getListBook().subscribe(book => {
      this.books = book;
    });
  }
  getCategory(): void {
    this.categoryService.getAllCategory().subscribe(category => {
      this.categories = category;
    });
  }

}
