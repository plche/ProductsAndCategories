package com.codingdojo.peru.ft2022.pnc.repositories;

import com.codingdojo.peru.ft2022.pnc.models.Category;
import com.codingdojo.peru.ft2022.pnc.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    // Recupera una lista de todas las categorías para un producto en particular.
    List<Category> findAllByProducts(Product product);

    // Recupera una lista de cualquier categoría
    // a la que un producto en particular no pertenece.
    List<Category> findByProductsNotContains(Product product);
}
