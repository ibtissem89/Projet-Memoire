import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from '../project-service.service';
import swal from 'sweetalert';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent {
  cartItems: any;
  total: number = 0;
  reduction = 0;
  cardNumber: string = '';
  expirationDate: string = '';
  cvv: string = '';
  selectedPaymentMethod: string = 'direct';
  transportForm: FormGroup;
  constructor(
    private router: Router,
    private service: ProjectServiceService,
    private fb: FormBuilder
  ) {
    this.transportForm = this.fb.group({
      adresse: ['', [Validators.required]],
      zipCode: ['', [Validators.required, Validators.minLength(4)]],
      ville: [''],
    });
  }

  submitPayment() {
    console.log('Payment submitted!');
  }
  ngOnInit() {
    if (localStorage.getItem('_id') != null) {
      this.getCarteByUser();
    } else {
      this.router.navigate(['login']);
    }
  }
  getCarteByUser() {
    const iduser = localStorage.getItem('_id');

    if (iduser == null) {
      this.router.navigate(['login']);
    } else {
      this.service.getCartItems(Number(iduser)).subscribe((items) => {
        console.log(items);
        if (items != null) {
          this.cartItems = items;
          this.calculTotale();
        }
      });
    }
  }
  calculTotale() {
    this.total = 0;
    this.cartItems.map((i: any) => (this.total += i.product.prix * i.quantity));
  }
  passerCmd() {
    switch (this.selectedPaymentMethod) {
      case 'visa': {
        this.router.navigate(['payment']);
        break;
      }
      default: {
        // Création de la commande et enregistrement
        const idUtilisateur = localStorage.getItem('_id');
        const adresseLivraison: string =
          this.transportForm.value.adresse +
          ' ' +
          this.transportForm.value.ville +
          ' ' +
          this.transportForm.value.zipCode;
          console.log(adresseLivraison);
          
        this.service
          .addNewCommande({
            userId: idUtilisateur,
            amount: this.total,
            adressLivraison: adresseLivraison,
          })
          .subscribe((data) => {
            swal(
              'Terminé',
              'Votre commande est en cours de traitement',
              'success'
            );
          });
      }
    }
  }
}
