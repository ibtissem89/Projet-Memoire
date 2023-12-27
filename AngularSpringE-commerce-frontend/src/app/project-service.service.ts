import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from './models/UserLogin';
import { Register } from './models/Register';
import { map } from 'rxjs/operators';
import { NumberFormatStyle } from '@angular/common';

@Injectable({
  providedIn: 'root',
})
export class ProjectServiceService {
  listofproduct: any[] = [];
  constructor(private http: HttpClient) {}

  loginUser(user: any): Observable<any> {
    return this.http.post('http://localhost:8080/login', user);
  }

  registerUser(register: any): Observable<any> {
    return this.http.post('http://localhost:8080/registerUser', register);
  }

  getallproducts(): Observable<any> {
    return this.http.get('http://localhost:8080/getallproducts');
  }
  getallproductsByCategory(categoryName:String): Observable<any> {
    return this.http.get(`http://localhost:8080/getproductbyCategory/${categoryName}`);
  }
  getallCategorys(): Observable<any> {
    return this.http.get('http://localhost:8080/allCategorys');
  }
  addproduct(product: any): Observable<any> {
    return this.http.post('http://localhost:8080/addproduct', product);
  }
  Addcontact(contact: any): Observable<any> {
    return this.http.post('http://localhost:8080/reclamations/add', contact);
  }
  getAllReclamation(): Observable<any> {
    return this.http.get('http://localhost:8080/reclamations');
  }

  deleteproduct(id: any): Observable<any> {
    return this.http.delete(`http://localhost:8080/deleteproduct/${id}`);
  }
  geproductbyid(id: any): Observable<any> {
    return this.http.get(`http://localhost:8080/getproductbyid/${id}`);
  }
  updateproduct(product: any): Observable<any> {
    return this.http.put('http://localhost:8080/updateproduct', product);
  }

  addToCarte(iduser: number, product: any) {
    return this.http.post(`http://localhost:8080/carte/add/${iduser}`, product);
  }
  removeCartItem(carteItem: number) {
    return this.http.delete(`http://localhost:8080/carte/remove/${carteItem}`);
  }

  updateCarte(cartItemId: number, qte: number) {
    return this.http.put(
      `http://localhost:8080/carte/update/${cartItemId}`,
      qte
    );
  }
  getCartItems(idUser: number) {
    return this.http.get(`http://localhost:8080/carte/getCartItems/${idUser}`);
  }
  addNewCommande(commande:any){
    return this.http.post(`http://localhost:8080/commandes/new`,commande);

  }
}
