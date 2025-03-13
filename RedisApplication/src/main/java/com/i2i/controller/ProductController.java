package com.i2i.controller;

import com.i2i.entity.Product;
import com.i2i.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/redis-template/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("remove/{id}")
    public ResponseEntity<String> remove(@PathVariable long id) {
        productService.deleteFromCache(id);
        return ResponseEntity.ok("Removed from cache");
    }

}
