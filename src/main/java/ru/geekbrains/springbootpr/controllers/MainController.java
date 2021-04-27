package ru.geekbrains.springbootpr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springbootpr.model.Buyer;
import ru.geekbrains.springbootpr.model.Product;
import ru.geekbrains.springbootpr.services.BuyerService;
import ru.geekbrains.springbootpr.services.ProductService;

import java.util.List;

@Controller
public class MainController {

    private final ProductService productService;
    private final BuyerService buyerService;

    @Autowired
    public MainController(ProductService productService, BuyerService buyerService) {
        this.productService = productService;
        this.buyerService = buyerService;
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

    // http://localhost:8189/productsById/1
    @GetMapping("/productsById/{id}")
    public String findAllProductsByBuyerId(@PathVariable Long id, Model model){
        List<Product> products = productService.findProductsByBuyerId(id);
        model.addAttribute("productsById", products);
        model.addAttribute("titleName", "Список продуктов по Id: " + id);
        return "ProductsById";
    }

    // http://localhost:8189/buyersByid/1
    @GetMapping("/buyersByid/{id}")
    public String findAllBuyersByProductId(@PathVariable Long id, Model model){
        List<Buyer> buyers = buyerService.findAllBuyersByProductId(id);
        model.addAttribute("buyersById", buyers);
        model.addAttribute("titleName", "Список покупателей по Id: " + id);
        return "BuyersById";
    }

    // http://localhost:8189/buy?buyer_id=1&product_id=1
    @GetMapping("/buy")
    public String buyProduct(@RequestParam(name = "buyer_id") Long buyer_id, @RequestParam(name = "product_id") Long product_id){
        productService.buyProduct(buyer_id, product_id);
        return "redirect:/productsById/" + buyer_id;
    }

    @GetMapping("/product/inc/{id}")
    public String incrementPriceProductById(@PathVariable Long id){
        productService.incrementPriceProductById(id);
        return "redirect:/";
    }

    @GetMapping("/product/dec/{id}")
    public String decrementPriceProductById(@PathVariable Long id){
        productService.decrementPriceProductById(id);
        return "redirect:/";
    }
}
