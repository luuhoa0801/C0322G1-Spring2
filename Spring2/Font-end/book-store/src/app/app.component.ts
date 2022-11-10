import { Component } from '@angular/core';
import firebase from "firebase";

const config = {
  apiKey: 'AIzaSyAplNpJCaP7mAPJph5asCEBs5EELmvyZlw',
  databaseURL: 'https://chatroom-7c8f4-default-rtdb.asia-southeast1.firebasedatabase.app'
};

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'book-store';

  constructor() {
    firebase.initializeApp(config);
  }
}
