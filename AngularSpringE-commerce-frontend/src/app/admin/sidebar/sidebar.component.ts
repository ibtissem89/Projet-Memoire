import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent implements OnInit {
  userEmail:String=""
  constructor(private router: Router) {}
  ngOnInit(){
   const res=localStorage.getItem("_email");
   if(res!=null){
    this.userEmail=res;
   }
  }
  signout() {
    localStorage.clear();
    this.router.navigate(['/']);
  }
}
