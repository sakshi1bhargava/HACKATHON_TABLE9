import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {MatTableModule, MatPaginatorModule, MatButtonModule, MatDialogModule} from '@angular/material';
import { CdkTableModule } from '@angular/cdk/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule} from '@angular/forms';
import { MessageComponent } from './message/message.component';
import { AddDailogComponent } from './add-dailog/add-dailog.component';
CdkTableModule
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MessageComponent,
    AddDailogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    FormsModule,
    CdkTableModule,
    MatPaginatorModule,
    MatButtonModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [AddDailogComponent,MessageComponent]
})
export class AppModule { }
