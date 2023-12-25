import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  isLoged: boolean = false;
  useremail: String = '';
  constructor() {}
  ngOnInit(){
    const storedEmail = localStorage.getItem("_email");

     if (storedEmail !== null && storedEmail !== undefined) {
      this.useremail = storedEmail.toString();
      this.isLoged=true;
    } else {
      this.isLoged=false;
    }
  }
  deconnexion(){
    localStorage.clear();
  }
}
