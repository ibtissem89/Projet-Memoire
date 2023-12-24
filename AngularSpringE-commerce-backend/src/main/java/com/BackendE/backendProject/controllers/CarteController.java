package com.BackendE.backendProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendE.backendProject.models.CartItem;
import com.BackendE.backendProject.models.Product;
import com.BackendE.backendProject.models.User;
import com.BackendE.backendProject.responses.Message;
import com.BackendE.backendProject.services.CarteService;
import com.BackendE.backendProject.services.LoginService;
import com.BackendE.backendProject.services.ProductService;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/carte")
public class CarteController {
    @Autowired
    private CarteService cartService;

    @Autowired
    private ProductService productRepository;

    @Autowired
    private LoginService userRepository;

    @PostMapping("/add/{idUser}")
    public ResponseEntity<Message> addToCart(@PathVariable(value = "idUser") Integer idUser,
            @RequestBody Product product) {
        try {
            // Fetch the authenticated user
            User user = userRepository.getUserById(idUser);

            // Fetch the product
            Product productRes = productRepository.getproductbyid(product.getIdProduct());

            // Create a new cart item
            CartItem cartItem = new CartItem();
            cartItem.setOwner(user);
            cartItem.setProduct(productRes);
            cartItem.setQuantity(1);

            // Save the cart item
            cartService.saveItem(cartItem);

            return ResponseEntity.ok(new Message("Item added to cart successfully"));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Message("Error adding item to cart"));
        }
    }

    @GetMapping("/getCartItems/{idUser}")
    public List<CartItem> getCartItems(@PathVariable(value = "idUser") Integer idUser) {
        // Fetch the authenticated user
        User user = userRepository.getUserById(idUser);

        // Fetch the cart items for the user
        List<CartItem> res = cartService.getCateItemsByUser(user);
        System.out.println(res.size());
        return res;
    }

    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<Message> updateCartItem(@PathVariable Integer cartItemId,
            @RequestBody Integer newQte) {
        try {
            CartItem cartItem = cartService.getCart(cartItemId);

            // Update the quantity
            cartItem.setQuantity(newQte);

            // Save the updated cart item
            cartService.saveItem(cartItem);

            return ResponseEntity.ok().body(new Message("carte item deleted"));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Message("Error updating cart item"));
        }
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<Message> removeCartItem(@PathVariable Integer cartItemId) {
        try {
            CartItem cartItem = cartService.getCart(cartItemId);

            // Remove the cart item
            cartService.removeItem(cartItem);

            return ResponseEntity.ok().body(new Message("carte item deleted"));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Message("Error removing cart item"));
        }
    }

    @DeleteMapping("emptyData/{userId}")
    public ResponseEntity<Message> emptyCarte(@PathVariable(value = "userId") Integer idUser) {
        try {
            // Fetch the authenticated user
            User user = userRepository.getUserById(idUser);

            cartService.emptyCarteUser(user);

            return ResponseEntity.ok(new Message("Items cleared from cart successfully"));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Message("Error clearing items  "));
        }
    }

}
