package com.codingdojo.peru.ft2022.pnc.services;

import com.codingdojo.peru.ft2022.pnc.models.Category;
import com.codingdojo.peru.ft2022.pnc.models.Product;
import com.codingdojo.peru.ft2022.pnc.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) return optionalCategory.get();
        else return null;
    }

    public List<Category> findCategoriesByProduct(Product product) {
        return categoryRepository.findAllByProducts(product);
    }

    public List<Category> findCategoriesByProductNotContains(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }
}
