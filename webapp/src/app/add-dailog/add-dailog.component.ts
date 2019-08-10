import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface Customer {
  Name:string;
  Order:string;
}
@Component({
  selector: 'app-add-dailog',
  templateUrl: './add-dailog.component.html',
  styleUrls: ['./add-dailog.component.scss']
})
export class AddDailogComponent implements OnInit {

  name: string;
  message:string;
  customerDetails: any

  constructor(
    public dialogRef: MatDialogRef<AddDailogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Customer
  ) { }

  ngOnInit() {
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
}
