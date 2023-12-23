import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-showuser',
  templateUrl: './showuser.component.html',
  styleUrls: ['./showuser.component.css']
})
export class ShowuserComponent implements OnInit{

  listofuser : any;
constructor(private projectServiceService: ProjectServiceService,private router:Router)
{

}
ngOnInit(): void {
    this.projectServiceService.getallproducts().subscribe
    (
      {
        next: (data)=>
        {
          this.listofuser = data
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
  const link =['admin/updateuser',id];
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
      this.projectServiceService.deleteproduct(id).subscribe(
        {
          next:(data)=>
          {
            swal("Poof! Your user has been deleted!", {
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

