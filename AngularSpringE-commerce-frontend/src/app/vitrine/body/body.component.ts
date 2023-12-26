import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from 'src/app/project-service.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css'],
})
export class BodyComponent implements OnInit {
  listofproduct: any[] = [];
  listofCategory: any[] = [];
  mobileProducts: any[] = [];
  smartphoneProducts: any[] = [];
  constructor(private service: ProjectServiceService, private router: Router) {}
  ngOnInit(): void {
    this.service.getallproducts().subscribe({
      next: (data) => {
        this.listofproduct = data;

        this.mobileProducts = this.listofproduct.filter(
          (product: any) => product.category.name == 'mobile'
        );
        this.smartphoneProducts = this.listofproduct.filter(
          (product: any) => product.category.name == 'smart tel'
        );
      },
    });
    this.service.getallCategorys().subscribe({
      next: (data) => {
        this.listofCategory = data;
      },
    });
  }
  addToCarte(product: any) {
    const iduser = localStorage.getItem('_id');
    if (iduser == null || iduser == undefined) {
      swal('login first!', 'u need to login first', 'warning').finally(() =>
        this.router.navigate(['login'])
      );
      this.router.navigate(['login']);
    } else {
      this.service.addToCarte(Number(iduser), product).subscribe((items) => {
        swal('Great!', 'Your choice has been added to ur carte!', 'success');
      });
    }
  }
}
