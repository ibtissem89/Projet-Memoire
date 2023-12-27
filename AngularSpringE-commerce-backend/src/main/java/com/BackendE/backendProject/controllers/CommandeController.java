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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendE.backendProject.models.Commande;
import com.BackendE.backendProject.requests.CommandeReq;
import com.BackendE.backendProject.services.CommandeService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("commandes")
public class CommandeController {
    @Autowired
    private CommandeService orderService;

    @GetMapping
    public List<Commande> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Commande> getOrderById(@PathVariable Long orderId) {
        Commande order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/new")
    public ResponseEntity<Commande> createOrder(@RequestBody CommandeReq order) {
        Commande savedOrder = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
