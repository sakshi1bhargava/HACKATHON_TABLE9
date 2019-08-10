import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material';
import { HttpClient } from '@angular/common/http';
import {AddDailogComponent} from '../app/add-dailog/add-dailog.component';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface PeriodicElement {
  count: string;
  queueName: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {queueName: 'Queue1', count: '10'},
  {queueName: 'Queue2', count: '20'},
  {queueName: 'Queue2', count: '2'},
  {queueName: 'Queue2', count: '3'},
  {queueName: 'Queue2', count: '11'},
  {queueName: 'Queue2', count: '22'},
  {queueName: 'Queue2', count: '9'},
  {queueName: 'Queue2', count: '6'},
  {queueName: 'Queue2', count: '4'},
  {queueName: 'Queue2', count: '1'},
];


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  displayedColumns: string[] = ['queueName', 'count', 'addBtn', 'checkBtn'];
  dataSource = ELEMENT_DATA;
  length = 100;
  pageSize = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  // MatPaginator Output
  pageEvent: PageEvent;
  constructor() { }

  setPageSizeOptions(setPageSizeOptionsInput: string) {
    this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
  }

  ngOnInit() {
  }

  addMessage(element) {
    const dialogRef = this.dialog.open(AddDailogComponent, {
      width:'50%',
      data:{
        row:element
      }
  
  }
  checkAvailability(element) {

  }

  showMessages(element) {

  }

}
