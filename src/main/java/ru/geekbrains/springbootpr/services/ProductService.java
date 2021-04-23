package ru.geekbrains.springbootpr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootpr.model.Product;
import ru.geekbrains.springbootpr.repositories.ProductDao;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public void save(Product product){
        productDao.save(product);
    }

    public void delete(Long id){
        productDao.deleteById(id);
    }

    public Optional<Product> findOneById(Long id) {
        return productDao.findOneById(id);
    }
}
