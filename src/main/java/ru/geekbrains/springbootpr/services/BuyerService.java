package ru.geekbrains.springbootpr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootpr.model.Buyer;
import ru.geekbrains.springbootpr.model.Product;
import ru.geekbrains.springbootpr.repositories.BuyerDao;
import ru.geekbrains.springbootpr.repositories.ProductDao;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    private final BuyerDao buyerDao;

    @Autowired
    public BuyerService(BuyerDao buyerDao) {
        this.buyerDao = buyerDao;
    }

    public List<Buyer> findAll(){
        return buyerDao.findAll();
    }

    public void save(Buyer buyer){
        buyerDao.save(buyer);
    }

    public void delete(Long id){
        buyerDao.deleteById(id);
    }

    public Optional<Buyer> findOneById(Long id) {
        return buyerDao.findOneById(id);
    }

    public List<Buyer> findAllBuyersByProductId(Long id){return buyerDao.findAllBuyersByProductId(id);}
}
