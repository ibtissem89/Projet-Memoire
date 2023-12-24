import { Component } from '@angular/core';
import { ProjectServiceService } from '../project-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent {
  cartItems: any;
  total:number=0;
  reduction=0;
  constructor(private router: Router, private service: ProjectServiceService) {}

  ngOnInit() {
    this.getCarteByUser();
  }

  getCarteByUser() {
    // const iduser = localStorage.getItem('_id');
    const iduser = 1;
    if (iduser == null) {
      this.service.getCartItems(Number(iduser)).subscribe((items) => {
        console.log(items);
        if (items != null) {
          this.cartItems = [];
          this.cartItems.concat(items);
        }
      });
      //this.router.navigate(['login']);
    } else {
      this.service.getCartItems(Number(iduser)).subscribe((items) => {
        console.log(items);
        if (items != null) {
          this.cartItems = items;
          this.calculTotale()
        }
      });
    }

  }

  plusQte(item: any) {
    item.quantity++; // Increase quantity locally
    this.updateQuantity(item, item.quantity);
  }

  minusQte(item: any) {
    if (item.quantity > 1) {
      item.quantity--; // Decrease quantity locally
     this.updateQuantity(item, item.quantity);
    }
  }

  updateQuantity(item: any, newQuantity: number) {
    this.service.updateCarte(item.id, newQuantity).subscribe(() => {
      // Refresh the cart items after updating quantity
      this.getCarteByUser();
    });
  }

  removeItem(item: any) {
    this.service.removeCartItem(item.id).subscribe((res) => {
      console.log(res);
      this.getCarteByUser();
    },
    (err)=>{
      console.log(err);
      
    });
  }
  calculTotale(){
    this.cartItems.map((i:any)=>this.total+=(i.product.prix*i.quantity));
  }
  toPayment(){
    this.router.navigate(["checkout"])
  }
}
