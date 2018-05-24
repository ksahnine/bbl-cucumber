import { Component } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'app';
  request = new Message();
  response: Message;

  constructor(private http: Http) {
  }

  send() {
    this.http.get(`/api/echo/${this.request.type}/${this.request.content}`).subscribe( data => {
      this.response = data.json() as Message; 
    });
  }

}

export class Message {
  constructor() { 
    this.type = 'strict'
  }
  content: string;
  type: string;
}
