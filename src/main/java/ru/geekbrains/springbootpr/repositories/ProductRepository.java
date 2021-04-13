package ru.geekbrains.springbootpr.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.springbootpr.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Water", 20F),
                new Product(2L, "Bread", 30F),
                new Product(3L, "Tea", 45F),
                new Product(4L, "Milk", 55F),
                new Product(5L, "Ice cream", 35F)
        ));
    }

    public List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        products.add(product);
    }

    public Optional<Product> findOneById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public void delete(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }
}
