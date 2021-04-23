package ru.geekbrains.springbootpr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springbootpr.model.Product;
import ru.geekbrains.springbootpr.services.ProductService;

import java.util.List;

@Controller
public class MainController {

    private final ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String getListProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "ProductList";
    }

    @GetMapping("/")
    public String showList(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "ProductList";
    }

    @GetMapping("/add")
    public String showAddProduct(){
        return "ActionProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/list";
    }

}
