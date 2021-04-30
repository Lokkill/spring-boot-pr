package ru.geekbrains.springbootpr.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.springbootpr.model.Buyer;
import ru.geekbrains.springbootpr.repositories.BuyerController;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    private BuyerController buyerController;

    public List<Buyer> findAll(){
        return buyerController.findAll();
    }

    public void save(Buyer buyer){
        buyerController.save(buyer);
    }

    public void delete(Long id){
        buyerController.deleteById(id);
    }

    public Optional<Buyer> findOneById(Long id) {
        return buyerController.findById(id);
    }

    public List<Buyer> findAllBuyersByProductId(Long id){return buyerController.hqlFindBuyersByProductId(id);}
}
