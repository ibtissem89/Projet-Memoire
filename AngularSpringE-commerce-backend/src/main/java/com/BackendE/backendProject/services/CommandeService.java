package com.BackendE.backendProject.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendE.backendProject.models.CartItem;
import com.BackendE.backendProject.models.Commande;
import com.BackendE.backendProject.models.OrderItem;
import com.BackendE.backendProject.models.User;
import com.BackendE.backendProject.repository.CommandeRepository;
import com.BackendE.backendProject.repository.OrderItemRepository;
import com.BackendE.backendProject.requests.CommandeReq;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private LoginService loginService;
    @Autowired
    private CarteService carteService;

    public List<Commande> getAllOrders() {
        return commandeRepository.findAll();
    }

    public Commande getOrderById(Long orderId) {
        return commandeRepository.findById(orderId).orElse(null);
    }

    public Commande saveOrder(CommandeReq order) {
        // Set the order date before saving
        User user = loginService.getUserById(order.getUserId());

        // Create a new order
        Commande orderEntity = new Commande();
        orderEntity.setUser(user);
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Define a formatter to format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Convert the date and time to a string using the formatter
        String formattedDateTime = currentDateTime.format(formatter);
        orderEntity.setOrderDate(formattedDateTime);
        orderEntity.setAmount(order.getAmount());
        orderEntity.setStatus("not approved");// default until admin approve on it 

        // Save the order to get the generated ID
        Commande savedOrder = commandeRepository.save(orderEntity);

        // Fetch all cart items for the user
        List<CartItem> cartItems = carteService.getCateItemsByUser(user);

        // Map and save order items
        List<OrderItem> orderItems = cartItems.stream().map(c -> {

            return orderItemRepository.save(new OrderItem(c.getProduct(), c.getQuantity(), savedOrder));

        }).toList();
        // Set the order items for the saved order
        savedOrder.setOrderItems(orderItems);

        // delete carteItems
        carteService.emptyCarteUser(user);

        // Save the order again to update the relationship

        return savedOrder;
    }

    public void deleteOrder(Long orderId) {
        commandeRepository.deleteById(orderId);
    }

    public Commande updateCommande(Long orderId, String newStatus) {
        Commande c = getOrderById(orderId);
        c.setStatus(newStatus);
        return commandeRepository.save(c);
    }
}