package ru.geekbrains.springbootpr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootpr.model.Buyer;
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

    public List<Product> findProductsByBuyerId(Long id){return productDao.findProductsByBuyerId(id);}

    public void buyProduct(Long buyer_id, Long product_id){
        productDao.buyProduct(buyer_id, product_id);
    }

    public void incrementPriceProductById(Long id){
        productDao.incrementPriceProductById(id);
    }

    public void decrementPriceProductById(Long id){
        productDao.decrementPriceProductById(id);
    }

}
