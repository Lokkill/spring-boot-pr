package ru.geekbrains.springbootpr.repositories;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.springbootpr.model.Buyer;
import ru.geekbrains.springbootpr.model.Product;
import ru.geekbrains.springbootpr.utils.HibernateUtils;

import java.util.List;
import java.util.Optional;

@Component
public class BuyerDao {
    private HibernateUtils utils;

    @Autowired
    public BuyerDao(HibernateUtils utils) {
        this.utils = utils;
    }


    public List<Buyer> findAll() {
        try(Session session = utils.getCurrentSession()) {
            session.beginTransaction();
            List<Buyer> products = session.createQuery("from Buyer").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void save(Buyer product) {
        try(Session session = utils.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    public Optional<Buyer> findOneById(Long id) {
        try(Session session = utils.getCurrentSession()) {
            session.beginTransaction();
            Optional<Buyer> product = Optional.ofNullable(session.get(Buyer.class, id));
            session.getTransaction().commit();
            return product;
        }
    }

    public void deleteById(Long id){
        try(Session session = utils.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from Buyer p where p.id = " + id).executeUpdate();
            session.getTransaction().commit();
        }
    }

    public List<Buyer> findAllBuyersByProductId(Long id){
        try (Session session = utils.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            List<Buyer> buyers = product.getBuyers();
            for (Buyer b : buyers){
                System.out.println(b.getId());
            }
            session.getTransaction().commit();
            return buyers;
        }
    }
}
