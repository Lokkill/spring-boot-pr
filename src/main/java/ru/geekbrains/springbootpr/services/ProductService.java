package ru.geekbrains.springbootpr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.springbootpr.model.Product;
import ru.geekbrains.springbootpr.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.delete(id);
    }

    public Optional<Product> findOneById(Long id) {
        return productRepository.findOneById(id);
    }
}
