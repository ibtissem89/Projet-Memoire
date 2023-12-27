import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from '../project-service.service';
import   swal from 'sweetalert';

@Component({
  selector: 'app-mobile',
  templateUrl: './mobile.component.html',
  styleUrls: ['./mobile.component.css'],
})
export class MobileComponent {
  pMobiles: any[] = [];
  constructor(private service: ProjectServiceService, private router: Router) {}
  ngOnInit(): void {
    this.service.getallproductsByCategory('mobile').subscribe({
      next: (data) => {
        this.pMobiles = data;
      },
    });
  }
  addToCarte(product: any) {
    const iduser = localStorage.getItem('_id');
    if (iduser == null || iduser == undefined) {
      swal(
        "Connectez-vous d'abord !",
        "Vous devez d'abord vous connecter",
        'warning'
      ).finally(() => this.router.navigate(['login']));
      this.router.navigate(['login']);
    } else {
      this.service.addToCarte(Number(iduser), product).subscribe((items) => {
        swal('Super !', 'Votre choix a été ajouté à votre panier !', 'success');
      });
    }
  }
}
