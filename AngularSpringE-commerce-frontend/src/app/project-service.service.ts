import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from './models/UserLogin';
import { Register } from './models/Register';
import { map } from 'rxjs/operators'




@Injectable({
  providedIn: 'root'
})
export class ProjectServiceService {
 
  listofproduct : any[]=[];
  constructor(private http : HttpClient) { }


  loginUser(user:any):Observable<any>
  {
    return this.http.post('http://localhost:8080/login',user);
  }
  
  registerUser(register: any): Observable<any> {
    
    return this.http.post('http://localhost:8080/registerUser',Register);
  }
 
  getallproducts():Observable<any>
  {
    return this.http.get("http://localhost:8080/getallproducts");
  }
  getallCategorys():Observable<any>
  {
    return this.http.get("http://localhost:8080/allCategorys");
  }
  addproduct(product : any):Observable<any>
  {
      return this.http.post("http://localhost:8080/addproduct",product);

  }
  Addcontact(contact : any):Observable<any>
  {
      return this.http.post("http://localhost:8080/contact",contact);

  }

      deleteproduct(id:any):Observable<any>
  {
      return this.http.delete(`http://localhost:8080/deleteproduct/${id}`);
  }
  geproductbyid(id:any):Observable<any>
  {
      return this.http.get(`http://localhost:8080/getproductbyid/${id}`);
  }
  updateproduct(product:any):Observable<any>
  {
    return this.http.put("http://localhost:8080/updateproduct",product)
  }

}
