package ru.geekbrains.springbootpr.repositories;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springbootpr.model.Buyer;
import ru.geekbrains.springbootpr.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuyerController extends JpaRepository<Buyer, Long> {
    Optional<Buyer> findById(Long id);
    List<Buyer> findAll();
    @Query("select p.buyers from Product p where p.id = :id")
    List<Buyer> hqlFindBuyersByProductId(Long id);
}
