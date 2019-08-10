import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { AddDailogComponent } from '../add-dailog/add-dailog.component';
import { DataService } from '../data.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
 
  displayedColumns: string[] = ['qId', 'msgId', 'msg', 'deletebtn'];
  dataSource : any[] = [];
  constructor( public dialogRef: MatDialogRef<MessageComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private dataService: DataService,
  private httpClient: HttpClient) { }

  ngOnInit() {
     const array = this.dataService.queueData.filter(ele => {
       return ele.qName === this.data.row.qName;
     })[0];
    this.dataSource = array.msgQueueLst;
  }

  deleteMessage(element) {
    this.httpClient.get('/message/deleteMessage/'+element.msgId).subscribe(res => {
      console.log(res);
      alert(res.content);
    });
  }

}
