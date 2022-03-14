package com.codingdojo.peru.ft2022.pnc.controllers;

import com.codingdojo.peru.ft2022.pnc.models.Category;
import com.codingdojo.peru.ft2022.pnc.models.Product;
import com.codingdojo.peru.ft2022.pnc.services.CategoryService;
import com.codingdojo.peru.ft2022.pnc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/categories/new")
    public String showNewCategoryForm(Model model) {
        model.addAttribute("newCategory", new Category());
        return "newcategory.jsp";
    }

    @PostMapping("/categories/new")
    public String saveNewCategory(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result) {
        // ToDo: Validar que la categoría no existe!
        if (result.hasErrors()) return "newcategory.jsp";
        else {
            categoryService.createCategory(newCategory);
            return "redirect:/products/new";
        }
    }

    @GetMapping("/categories/{id}")
    public String showCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findCategoryById(id);
        if (category != null) {
            model.addAttribute("productsCategoryNotIn", productService.findProductsByCategoryNotContains(category));
            model.addAttribute("category", category);
            return "showcategory.jsp";
        } else return null; // ToDo: Enviar mensaje de error: Categoría No Existe!
    }

    @PostMapping("/categories/{id}/products/add")
    public String productAddToCategory(@PathVariable("id") Long id, @RequestParam(value = "productId") Long productId) {
        Category category = categoryService.findCategoryById(id);
        Product product = productService.findProductById(productId);
        category.getProducts().add(product);
        categoryService.createCategory(category);
        return "redirect:/categories/" + id;
    }
}
