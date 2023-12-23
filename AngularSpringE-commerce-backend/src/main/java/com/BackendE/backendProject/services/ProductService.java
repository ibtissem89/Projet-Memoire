package com.BackendE.backendProject.services;

import com.BackendE.backendProject.models.Product;
import com.BackendE.backendProject.repository.ProductRepository;

import com.BackendE.backendProject.requests.ProductReq;
import com.BackendE.backendProject.responses.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> getallproducts()
    {
        return productRepository.findAll();
    }


    public Message deleteProduct(Integer id) {
        Optional<Product> Productbyid = productRepository.findById(id);
        if(Productbyid.isPresent()==false)
        {
            throw new IllegalStateException("Product dosent exist !");
        }
        else {
            productRepository.deleteById(id);
            Message m = new Message("Product has been deleted ! ");
            return m;
        }
    }

    public Message addproduct(ProductReq productReq) throws SQLException {
      byte[] decodedByte = Base64.getDecoder().decode(productReq.getImage());
      Blob b = new SerialBlob(decodedByte);
      Product p = new Product(productReq.getName(),productReq.getPrix(),b,productReq.getType());
      productRepository.save(p);
      Message m = new Message("Product has been added ! ");
      return m;

    }

    public Message updateProduct(ProductReq productReq) throws SQLException {

        System.out.println(productReq);
        Product productByid = productRepository.findById(productReq.getIdProduct()).orElse(null);
        if(productByid==null)
        {
            throw new IllegalStateException("Product dosent exist !");
        }
        else
        {
            byte[] decodedByte = Base64.getDecoder().decode(productReq.getImage());
            Blob b = new SerialBlob(decodedByte);
            productByid.setName(productReq.getName());
            productByid.setPrix(productReq.getPrix());
            productByid.setType(productReq.getType());
            productByid.setImage(b);
            productRepository.save(productByid);
            Message m = new Message("Product has been updated ! ");
            return m;
        }
    }

    public Product getproductbyid(Integer id) {
      return   this.productRepository.findById(id).orElse(null);
    }
}
