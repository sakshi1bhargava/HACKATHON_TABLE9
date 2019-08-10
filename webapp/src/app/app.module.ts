import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {MatTableModule, MatPaginatorModule, MatButtonModule,} from '@angular/material';
import { CdkTableModule } from '@angular/cdk/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MessageComponent } from './message/message.component';
CdkTableModule
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MessageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    CdkTableModule,
    MatPaginatorModule,
    MatButtonModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
