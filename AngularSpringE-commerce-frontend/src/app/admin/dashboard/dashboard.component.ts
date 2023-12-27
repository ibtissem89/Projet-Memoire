import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from 'src/app/project-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  listofCategory:any[]=[]
  constructor(private router:Router,private service: ProjectServiceService){}
  ngOnInit(): void {

    const role=localStorage.getItem("_role");
    if(role==null||role==undefined||role.toLowerCase()!="admin"){
      this.router.navigate(['notFound']);
    }
    this.service.getallCategorys().subscribe({
      next: (data) => {
        this.listofCategory = data;
      },
    });
  }
}
