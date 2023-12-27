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
  products: any[] = [];
  constructor(private service: ProjectServiceService, private router: Router) {}
  ngOnInit(): void {
    this.service.getallproductsByCategory('smart tel').subscribe({
      next: (data) => {
        this.products = data;
        console.log(this.products);
        
      },
    });
  }

  addToCarte(product: any) {
    const iduser = localStorage.getItem('_id');
    if (iduser == null || iduser == undefined) {
      swal('Connectez-vous d\'abord !', 'Vous devez d\'abord vous connecter', 'warning').finally(() =>
        this.router.navigate(['login'])
      );
      this.router.navigate(['login']);
    } else {
      this.service.addToCarte(Number(iduser), product).subscribe((items) => {
        swal('Super !', 'Votre choix a été ajouté à votre panier !', 'success');
      });
    }
  }
}
