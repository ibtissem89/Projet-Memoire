import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-showproduct',
  templateUrl: './showproduct.component.html',
  styleUrls: ['./showproduct.component.css'],
})
export class ShowproductComponent implements OnInit {
  listofproducts: any;
  constructor(private service: ProjectServiceService, private router: Router) {}
  ngOnInit(): void {
    this.service.getallproducts().subscribe({
      next: (data) => {
        this.listofproducts = data;
      },
      error: (errr) => {
        console.log(errr);
      },
    });
  }

  updateproduct(id: any) {
    const link = ['admin/updateproduct', id];
    this.router.navigate(link);
  }

  deleteproduct(id: any) {
    swal({
      title: 'Êtes-vous sûr(e) ?',
      text: 'Une fois supprimé(e), vous ne pourrez pas récupérer ce produit !',
      icon: 'warning',
      dangerMode: true,
    }).then((willDelete) => {
      if (willDelete) {
        this.service.deleteproduct(id).subscribe({
          next: (data) => {
            swal('Hourra ! Votre produit a été supprimé !', {
              icon: 'success',
            });
            setTimeout(() => {
              location.reload();
            }, 1500);
          },
          error: (err) => {
            swal('Désolé(e) !', 'Veuillez réessayer plus tard !', 'error');
          },
        });
      }
    });
  }
}
