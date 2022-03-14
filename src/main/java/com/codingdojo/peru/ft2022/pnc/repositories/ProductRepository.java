package com.codingdojo.peru.ft2022.pnc.repositories;

import com.codingdojo.peru.ft2022.pnc.models.Category;
import com.codingdojo.peru.ft2022.pnc.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    // Recupera una lista de todas los productos para una categoría en particular.
    List<Product> findAllByCategories(Category category);

    // Recupera una lista de cualquier producto
    // a la que una categoría en particular no pertenece.
    List<Product> findByCategoriesNotContains(Category category);
}
