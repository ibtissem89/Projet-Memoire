import { Component, OnInit } from '@angular/core';
import { ProjectServiceService } from 'src/app/project-service.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit{
  
  listofproduct : any[]=[];
  listofCategory:any[]=[];
  constructor(private service: ProjectServiceService)
  {

  }
  ngOnInit(): void {

    this.service.getallproducts().subscribe(
    {
    next:(data)=>
    {
      this.listofproduct=data;
    }
    });
    this.service.getallCategorys().subscribe
    (
      {
        next:(data)=>
        {
          this.listofCategory=data;
          console.log(data)
        }
      }
    )

    
  }


}
