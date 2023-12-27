import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectServiceService } from '../project-service.service';
import swal from 'sweetalert';

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
  constructor(private router: Router, private service: ProjectServiceService) {}

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
        // cretaing order and saving it
        const iduser = localStorage.getItem('_id');
        this.service
          .addNewCommande({ userId: iduser, amount: this.total })
          .subscribe((data) => {
            swal('done', 'ur order is in process', 'success');
          });
      }
    }
  }
}
