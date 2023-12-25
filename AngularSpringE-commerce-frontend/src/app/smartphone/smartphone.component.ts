import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from '../project-service.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-smartphone',
  templateUrl: './smartphone.component.html',
  styleUrls: ['./smartphone.component.css'],
})
export class SmartphoneComponent {
  constructor(private router: Router, private service: ProjectServiceService) {}
  products: any[] = [
    {
      idProduct: 1,
      name: 'p1',
      prix: '202',
      image: '',
      type: 'phone',
    },
  ];
  addToCarte() {
    const iduser = localStorage.getItem('_id');
    if (iduser == null||iduser == undefined) {
      swal('login first!', 'u need to login first', 'warning').finally(() =>
        this.router.navigate(['login'])
      );
      this.router.navigate(['login']);
    } else {
      this.service
        .addToCarte(Number(iduser), this.products[0])
        .subscribe((items) => {
          swal('Great!', 'Your choice has been added to ur carte!', 'success');
        });
    }
  }
}
