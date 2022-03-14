package com.codingdojo.peru.ft2022.pnc.services;

import com.codingdojo.peru.ft2022.pnc.models.Category;
import com.codingdojo.peru.ft2022.pnc.models.Product;
import com.codingdojo.peru.ft2022.pnc.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) return optionalProduct.get();
        else return null;
    }

    public List<Product> findProductsByCategory(Category category) {
        return productRepository.findAllByCategories(category);
    }

    public List<Product> findProductsByCategoryNotContains(Category category) {
        return productRepository.findByCategoriesNotContains(category);
    }
}
