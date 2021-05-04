package ru.geekbrains.springbootpr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springbootpr.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductController extends JpaRepository<Product, Long> {
    Optional<Product> findOneByTitle(String title);
    List<Product> findAllByPriceBetweenAndTitleContains(int min, int max, String title);
    List<Product> findAllByPriceBetween(int min, int max);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    @Query("select b.products from Buyer b where b.id = :id")
    List<Product> hqlFindProductsByBuyerId(Long id);

    @Modifying
    @Query("update Product p set p.price = p.price + 10 where p.id = :id")
    void hqlIncrementPriceProductById(Long id);

    @Modifying
    //@Query("update Product p set p.price = (case when p.price>10 then p.price - 10 else p.price end) where p.id = ?1")
    @Query("update Product p set p.price = p.price - 10 where p.id = :id")
    void hqlDecrementPriceProductById(Long id);

//    @Modifying
//    @Query("update buyers_products bp set bp.buyer_id = :buyer_id, bp.product_id = :product_id")
//    void hqlBuyProduct(Long buyer_id, Long product_id);

}
