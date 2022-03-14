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
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/products/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("newProduct", new Product());
        return "newproduct.jsp";
    }

    @PostMapping("/products/new")
    public String saveNewProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
        if (result.hasErrors()) return "newproduct.jsp";
        else {
            productService.createProduct(newProduct);
            return "redirect:/categories/new";
        }
    }

    @GetMapping("/products/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        Product product = productService.findProductById(id);
        if (product != null) {
            model.addAttribute("categoriesProductNotIn", categoryService.findCategoriesByProductNotContains(product));
            model.addAttribute("product", product);
            return "showproduct.jsp";
        } else return null; // ToDo: Enviar mensaje de error: Producto No Existe!
    }

    @PostMapping("/products/{id}/categories/add")
    public String categoryAddToProduct(@PathVariable("id") Long id, @RequestParam(value = "categoryId") Long categoryId) {
        Product product = productService.findProductById(id);
        Category category = categoryService.findCategoryById(categoryId);
        product.getCategories().add(category);
        productService.createProduct(product);
        return "redirect:/products/" + id;
    }
}
