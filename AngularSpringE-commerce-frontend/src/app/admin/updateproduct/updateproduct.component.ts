import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: ['./updateproduct.component.css','../../../assets/css/demo.css','../../../assets/css/wizard.css']
})
export class UpdateproductComponent implements OnInit{

  productbyid:any;

  constructor(private activatedRoute:ActivatedRoute,private service : ProjectServiceService)
  {

  }

  ngOnInit(): void {
      this.activatedRoute.params.subscribe(
        {
          next:(data)=>
          {
              this.service.geproductbyid(data["id"]).subscribe(
                {
                  next:(data)=>
                  {
                    this.productbyid=data;
                  },
                  error:(err)=>
                  {
                    console.log(err);
                  }
                  
                }
              )
          },
          error:(err)=>
          {

          }
        }
      )
  }

  updateproduct(form:any)
  {

   this.service.updateproduct(this.productbyid).subscribe(
    {
      next:(data)=>
      {
        swal("Good job!", "Your product has been updated!", "success");
      },
      error:(err)=>
      {
        swal("Sorry!", "You need to try later !", "error");
      }
    }
   )
  }

  getfile(event: any)
  {
    const file = event.target.files[0];
   
    if(file)
    {
      const reader = new FileReader();
      reader.onload = (e : any)=>
      {
        const base64Image = e.target.result;
        this.productbyid.image = base64Image.slice(base64Image.indexOf(",")+1)

      };
      reader.readAsDataURL(file);
    }
  }
}
