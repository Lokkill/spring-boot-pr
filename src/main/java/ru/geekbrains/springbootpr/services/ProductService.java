package ru.geekbrains.springbootpr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootpr.model.Product;
import ru.geekbrains.springbootpr.repositories.ProductController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductController productDao;

    @Autowired
    public ProductService(ProductController productDao) {
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
        return productDao.findById(id);
    }

    public List<Product> findProductsByBuyerId(Long id){return productDao.hqlFindProductsByBuyerId(id);}

    public void buyProduct(Long buyer_id, Long product_id){
        //productDao.buyProduct(buyer_id, product_id);
    }

    @Transactional
    public void incrementPriceProductById(Long id){
        productDao.hqlIncrementPriceProductById(id);
    }

    @Transactional
    public void decrementPriceProductById(Long id){
        productDao.hqlDecrementPriceProductById(id);
    }

    public List<Product> filterProduct(int min, int max, String title) {
        return productDao.findAllByPriceBetweenAndTitleContains(min, max, title);
    }
}
