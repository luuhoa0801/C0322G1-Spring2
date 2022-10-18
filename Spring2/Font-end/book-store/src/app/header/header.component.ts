import {Component, OnInit} from '@angular/core';
import {Category} from "../model/category";
import {CategoryService} from "../service/category.service";
import {Router} from "@angular/router";
import {TokenStorageService} from "../service/token-storage.service";
import {ShareService} from "../service/share.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  categoryList: Category[] = [];
  username: string;
  currentUser: string;
  role: string;
  isLoggedIn = false;

  formSearch = new FormGroup({
    search: new FormControl()
  });
  constructor(private categoryService: CategoryService,
              private router: Router,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadEditAdd();
    });
  }

  ngOnInit(): void {
    this.categoryService.getAllCategory().subscribe(value => {
      this.categoryList = value;
      console.log(value);
    });
    this.loadEditAdd()
  }

  getCategory(id: number) {
    this.router.navigateByUrl(`list/` + id +`/`)
  }
  loadEditAdd(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
  }

  logOut() {
    this.tokenStorageService.signOut();
  }

  // search() {
  //   if (this.formSearch.get('name').value == null || this.formSearch.get('name').value === '' + '') {
  //     this.router.navigateByUrl('/book/list');
  //   } else {
  //     this.router.navigateByUrl('/book/list' + this.formSearch.get('name').value);
  //   }
  // }
  search() {
    console.log(this.formSearch)
    this.router.navigateByUrl(`list/0/` +this.formSearch.value.search);
  }
}
