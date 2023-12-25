import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminpanel',
  templateUrl: './adminpanel.component.html',
  styleUrls: ['./adminpanel.component.css','../sidebar/sidebar.component.css']
})
export class AdminpanelComponent implements OnInit {
  constructor(private router:Router){}
  ngOnInit(): void {

    const role=localStorage.getItem("_role");
    if(role==null||role==undefined||role.toLowerCase()!="admin"){
      this.router.navigate(['notFound']);
    }
  }

}
