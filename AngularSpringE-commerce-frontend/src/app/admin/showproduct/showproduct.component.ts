import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-showproduct',
  templateUrl: './showproduct.component.html',
  styleUrls: ['./showproduct.component.css']
})
export class ShowproductComponent implements OnInit{

  listofproducts : any;
constructor(private service : ProjectServiceService,private router:Router)
{

}
ngOnInit(): void {
    this.service.getallproducts().subscribe
    (
      {
        next: (data)=>
        {
          this.listofproducts = data
        },
        error:(errr)=>
        {
          console.log(errr)
        }
      }
    )
}

updateproduct(id:any)
{
  const link =['admin/updateproduct',id];
  this.router.navigate(link);
}

deleteproduct(id:any)
{
  swal({
    title: "Are you sure?",
    text: "Once deleted, you will not be able to recover this product!",
    icon: "warning",
   
    dangerMode: true,
  })
  .then((willDelete) => {
    if (willDelete) {
      this.service.deleteproduct(id).subscribe(
        {
          next:(data)=>
          {
            swal("Poof! Your product has been deleted!", {
              icon: "success",
            });
            setTimeout(()=>{                           // <<<---using ()=> syntax
              location.reload();
          }, 1500);
          
          },
          error:(err)=>
          {
            swal("Sorry!", "You need to try later !", "error");

          }
        }
      )
     
    }
  });
}
}
