import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material';
import { HttpClient } from '@angular/common/http';
import {AddDailogComponent} from '../add-dailog/add-dailog.component';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { MessageComponent } from '../message/message.component';
import { DataService } from '../data.service';


export interface PeriodicElement {
  qId: number;
  qName: string;
}

const ELEMENT_DATA: any[] = [
  // {qName: 'Queue1', qid: '10'},
  // {qName: 'Queue2', qid: '20'},
  // {qName: 'Queue2', qid: '2'},
  // {qName: 'Queue2', qid: '3'},
  // {qName: 'Queue2', qid: '11'},
  // {qName: 'Queue2', qid: '22'},
  // {qName: 'Queue2', qid: '9'},
  // {qName: 'Queue2', qid: '6'},
  // {qName: 'Queue2', qid: '4'},
  // {qName: 'Queue2', qid: '1'},
];


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  displayedColumns: string[] = ['qName', 'qid', 'addBtn', 'checkBtn', 'deleteBtn'];
   dataSource : any[] = [];
  length = 100;
  pageSize = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  // MatPaginator Output
  pageEvent: PageEvent;
  constructor(public httpClient: HttpClient, private dialog: MatDialog, public dataService: DataService) { }

  setPageSizeOptions(setPageSizeOptionsInput: string) {
    this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
  }

  ngOnInit() {
    const url = window.location.protocol+ '//'+ window.location.host+'/queue';   
    this.httpClient.get(url).subscribe(res => {
      console.log(res);
      const array = [];
      res.forEach(element => {
        array.push({qName: element.qName, qid: element.qid});
      });
      this.dataSource = array;
      this.dataService.queueData = res;
    });
  }

  addQueue() {
    const dialogRef = this.dialog.open(AddDailogComponent, {
      width:'50%',
      data:{
        row:''
      }
    });
  }


  deleteQueue(element) {
    this.httpClient.get('queue/'+element.qid).subscribe(res => {
      console.log(res);
      alert(res.content);
    });
  }
  addMessage(element) {
    const dialogRef = this.dialog.open(AddDailogComponent, {
      width:'50%',
      data:{
        row:element
      }
    });
  }

  checkAvailability(element) {
    this.httpClient.get('').subscribe(res => {
      console.log(res);
    });
  }

  showMessages(element) {
    const dialogRef = this.dialog.open(MessageComponent, {
      width:'50%',
      data:{
        row:element
      }
    });
  }

}
