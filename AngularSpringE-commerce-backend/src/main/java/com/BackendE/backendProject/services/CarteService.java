package com.BackendE.backendProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendE.backendProject.models.CartItem;
import com.BackendE.backendProject.models.User;
import com.BackendE.backendProject.repository.CarteRepository;

@Service
public class CarteService {

    @Autowired
    private CarteRepository carteRepository;

    public List<CartItem> getCateItemsByUser(User user) {
        return carteRepository.findByOwner(user).orElse(null);
    }

    public CartItem getCart(Integer carteId) {

        CartItem resCarte = carteRepository.findById(carteId).orElse(null);
        if (resCarte == null) {
            throw new IllegalStateException("carte user not found");
        }
        return resCarte;
    }

    public void saveItem(CartItem c) {

        carteRepository.save(c);

    }

    public void removeItem(CartItem c) {
        carteRepository.delete(c);
    }

    public void emptyCarteUser(User user) {
        List<CartItem> res = getCateItemsByUser(user);
        carteRepository.deleteAll(res);
    }

}
