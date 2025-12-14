package com.shop.Service;

import com.shop.model.Sweet;
import com.shop.repository.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetService {

    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    public Sweet addSweet(Sweet sweet) {
        return sweetRepository.save(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweetRepository.findAll();
    }

    public Sweet updateSweet(Long id, Sweet updatedSweet) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        sweet.setName(updatedSweet.getName());
        sweet.setCategory(updatedSweet.getCategory());
        sweet.setPrice(updatedSweet.getPrice());
        sweet.setQuantity(updatedSweet.getQuantity());

        return sweetRepository.save(sweet);
    }

    public void deleteSweet(Long id) {
        sweetRepository.deleteById(id);
    }

    public List<Sweet> searchByName(String name) {
        return sweetRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Sweet> searchByCategory(String category) {
        return sweetRepository.findByCategoryIgnoreCase(category);
    }

    public List<Sweet> searchByPrice(double min, double max) {
        return sweetRepository.findByPriceBetween(min, max);
    }
}
