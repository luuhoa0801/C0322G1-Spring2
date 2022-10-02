import { Component, OnInit } from '@angular/core';
import {Category} from "../model/category";
import {CategoryService} from "../service/category.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  categoryList: Category[]=[];
  constructor(private categoryService: CategoryService,
              private router : Router) { }

  ngOnInit(): void {
this.categoryService.getAllCateory().subscribe(value => {
  this.categoryList = value;
});

  }

  // getBookType(id: number) {
  //   this.router.navigate([`book/list/${id}/#`]);
  // }


  getCategory(id: number) {
    // this.router.navigateByUrl()
  }
}
