import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
HttpClient
@Injectable({
  providedIn: 'root'
})
export class DataService {
queueData: any;
  constructor(public httpClient: HttpClient) { }



}
