package com.shop.Controller;

import com.shop.model.Sweet;
import com.shop.Service.SweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    // ADD SWEET
    @PostMapping
    public Sweet addSweet(@RequestBody Sweet sweet) {
        return sweetService.addSweet(sweet);
    }

    // GET ALL SWEETS
    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }

    // UPDATE SWEET
    @PutMapping("/{id}")
    public Sweet updateSweet(@PathVariable Long id, @RequestBody Sweet sweet) {
        return sweetService.updateSweet(id, sweet);
    }

    // DELETE SWEET
    @DeleteMapping("/{id}")
    public String deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
        return "Sweet deleted successfully";
    }

    // SEARCH
    @GetMapping("/search")
    public List<Sweet> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        if (name != null)
            return sweetService.searchByName(name);
        if (category != null)
            return sweetService.searchByCategory(category);
        if (minPrice != null && maxPrice != null)
            return sweetService.searchByPrice(minPrice, maxPrice);

        return sweetService.getAllSweets();
    }
}

