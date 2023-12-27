import { Component } from '@angular/core';
import { ProjectServiceService } from '../project-service.service';
import { Route, Router } from '@angular/router';
import swal from 'sweetalert';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent {
  formInspector: FormGroup | any;
  constructor(
    private service: ProjectServiceService,
    private router: Router,
    private fb: FormBuilder
  ) {}
  cardNumber: string = '';
  expiryDate: string = '';
  cvv: string = '';
  amount: number = 0;
  paymentSuccess: boolean = false;
  paymentError: boolean = false;
  formSubmitted: boolean = false;

  ngOnInit() {
    this.formInspector = this.fb.group({
      cvv: ['', [Validators.required, Validators.pattern(/^\d{3}$/)]],
      expiryDate: [
        '',
        [Validators.required, Validators.pattern(/^(0[1-9]|1[0-2])\/\d{4}$/)],
      ],
      cardNumber: ['', Validators.required],
    });

    const iduser = localStorage.getItem('_id');
    this.service.getCartItems(Number(iduser)).subscribe((items) => {
      console.log(items);
      if (items != null) {
        let cartItems: any[] = items as any[];
        cartItems.map((i: any) => (this.amount += i.product.prix * i.quantity));
      }
    });
  }
  processPayment() {
    this.formSubmitted = true;
    this.cardNumber = this.formInspector.value.cardNumber;
    this.expiryDate = this.formInspector.value.expiryDate;
    this.cvv = this.formInspector.value.cvv;
    console.log(
      this.cardNumber + '-' + this.expiryDate + '-' + this.cvv + '-' + this.amount
    );

    if (!this.cardNumber || !this.expiryDate || !this.cvv || !this.amount) {
      // Le formulaire est invalide
      swal('Erreur', 'Le formulaire est invalide', 'error');
      return;
    }

    const iduser = localStorage.getItem('_id');
    this.service
      .addNewCommande({ userId: iduser, amount: this.amount })
      .subscribe((data) => {
        swal('Terminé', 'Votre commande est en cours de traitement', 'success');
      });
}

}
