import {Component, OnInit} from '@angular/core';
import {Chart, registerables} from "chart.js";
import {FormControl, FormGroup} from "@angular/forms";
import {BookService} from "../service/book.service";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-top-book',
  templateUrl: './top-book.component.html',
  styleUrls: ['./top-book.component.css']
})
export class TopBookComponent implements OnInit {
  topBookList: FormGroup = new FormGroup({
    startDate: new FormControl(),
    endDate: new FormControl(),
    type: new FormControl('book'),
  })
  myChart: any = {};

  constructor(private bookService: BookService,
              private title: Title) {
    this.title.setTitle("Thống kê")
    Chart.register(...registerables);
  }

  ngOnInit(): void {
    this.myChart = new Chart('myChart', {
      type: 'bar',
      data: {
        labels: ['', '', '', '', '', ''],
        datasets: [{
          label: '#Số lượng: ',
          data: [0, 0, 0, 0, 0, 0],
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',

          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',

          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }

  submit() {
    this.myChart.destroy();
    if (this.topBookList.value.type == 'book') {
      this.bookService.topBook(this.topBookList.value.startDate, this.topBookList.value.endDate).subscribe(value => {
        const data = [];
        const label = [];
        const color = []
        const backgroundColor = []
        for (let i = 0; i < value.length; i++) {
          let r = Math.floor(Math.random() * 254);
          let g = Math.floor(Math.random() * 254);
          let b = Math.floor(Math.random() * 254);
          data[i] = value[i].amount;
          label[i] = value[i].name;
          color[i] = 'rgba(' + r + ',' + g + ',' + b + ',0.2)';
          backgroundColor[i] = 'rgba(' + r + ',' + g + ',' + b + ',1)';
        }
        this.myChart = new Chart('myChart', {
          type: 'bar',
          data: {
            labels: label,
            datasets: [{
              label: '# Số lượng: ',
              data,
              backgroundColor: color,
              borderColor: backgroundColor,
              borderWidth: 1
            }]
          },
          options: {
            scales: {
              y: {
                beginAtZero: true
              }
            }
          }
        });
      })
    }else {
      this.bookService.getBuyBook().subscribe(value => {

        const data = [];
        const label = [];
        const color = []
        const backgroundColor = []
        for (let i = 0; i < value.length; i++) {
          let r = Math.floor(Math.random() * 254);
          let g = Math.floor(Math.random() * 254);
          let b = Math.floor(Math.random() * 254);
          data[i] = value[i].amount;
          label[i] = value[i].name;
          color[i] = 'rgba(' + r + ',' + g + ',' + b + ',0.2)';
          backgroundColor[i] = 'rgba(' + r + ',' + g + ',' + b + ',1)';
        }
        this.myChart = new Chart('myChart', {
          type: 'bar',
          data: {
            labels: label,
            datasets: [{
              label: '# Số lượng: ',
              data,
              backgroundColor: color,
              borderColor: backgroundColor,
              borderWidth: 1
            }]
          },
          options: {
            scales: {
              y: {
                beginAtZero: true
              }
            }
          }
        });
      })
    }
  }
}
