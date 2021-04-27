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
public class ProductDao {
    private HibernateUtils utils;

    @Autowired
    public ProductDao(HibernateUtils utils) {
        this.utils = utils;
    }


    public List<Product> findAll() {
        try(Session session = utils.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void save(Product product) {
        try(Session session = utils.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    public Optional<Product> findOneById(Long id) {
        try(Session session = utils.getCurrentSession()) {
            session.beginTransaction();
            Optional<Product> product = Optional.ofNullable(session.get(Product.class, id));
            session.getTransaction().commit();
            return product;
        }
    }

    public void deleteById(Long id){
        try(Session session = utils.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from Product p where p.id = " + id).executeUpdate();
            session.getTransaction().commit();
        }
    }

    public List<Product> findProductsByBuyerId(Long id){
        try (Session session = utils.getCurrentSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            List<Product> products = buyer.getProducts();
            for (Product p : products){
                System.out.println(p.getId());
            }
            session.getTransaction().commit();
            return products;
        }
    }
}
