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

  // Authentication and Registration
  // -------------------------------------------------------------

  // Login user
  loginUser(user: any): Observable<any> {
    return this.http.post('http://localhost:8080/login', user);
  }

  // Register user
  registerUser(register: any): Observable<any> {
    return this.http.post('http://localhost:8080/registerUser', register);
  }

  // Products
  // -------------------------------------------------------------

  // Get all products
  getallproducts(): Observable<any> {
    return this.http.get('http://localhost:8080/getallproducts');
  }

  // Get all products by category
  getallproductsByCategory(categoryName: String): Observable<any> {
    return this.http.get(
      `http://localhost:8080/getproductbyCategory/${categoryName}`
    );
  }

  // Add new product
  addproduct(product: any): Observable<any> {
    return this.http.post('http://localhost:8080/addproduct', product);
  }
  // Get all product Categories
  getallCategorys(): Observable<any> {
    return this.http.get('http://localhost:8080/allCategorys');
  }
  // Delete product

  // Delete product by ID
  deleteproduct(id: any): Observable<any> {
    return this.http.delete(`http://localhost:8080/deleteproduct/${id}`);
  }
  // Update product
  updateproduct(product: any): Observable<any> {
    return this.http.put('http://localhost:8080/updateproduct', product);
  }

  // Get product by ID

  geproductbyid(id: any): Observable<any> {
    return this.http.get(`http://localhost:8080/getproductbyid/${id}`);
  }
  // Reclamations
  // -------------------------------------------------------------

  // Add new reclamation
  addReclamation(contact: any): Observable<any> {
    return this.http.post('http://localhost:8080/reclamations/add', contact);
  }

  // Get all reclamations
  getAllReclamation(): Observable<any> {
    return this.http.get('http://localhost:8080/reclamations');
  }

  // Cart
  // -------------------------------------------------------------

  // Add product to cart
  addToCarte(iduser: number, product: any): Observable<any> {
    return this.http.post(`http://localhost:8080/carte/add/${iduser}`, product);
  }

  // Remove item from cart
  removeCartItem(carteItem: number): Observable<any> {
    return this.http.delete(`http://localhost:8080/carte/remove/${carteItem}`);
  }

  // Update cart item quantity
  updateCarte(cartItemId: number, qte: number): Observable<any> {
    return this.http.put(
      `http://localhost:8080/carte/update/${cartItemId}`,
      qte
    );
  }

  // Get cart items for a user
  getCartItems(idUser: number): Observable<any> {
    return this.http.get(`http://localhost:8080/carte/getCartItems/${idUser}`);
  }

  // Commands
  // -------------------------------------------------------------

  // Add new command
  addNewCommande(commande: any): Observable<any> {
    return this.http.post(`http://localhost:8080/commandes/new`, commande);
  }

  // Get all commands
  getAllCommandes(): Observable<any> {
    return this.http.get('http://localhost:8080/commandes');
  }

  // Update command status
  updateCommandeStatus(idOrder: number, newStatus: string): Observable<any> {
    return this.http.put(
      `http://localhost:8080/commandes/updateStatus/${idOrder}`,
      newStatus
    );
  }
}
