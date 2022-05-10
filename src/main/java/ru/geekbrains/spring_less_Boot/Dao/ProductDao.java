package ru.geekbrains.spring_less_Boot.Dao;

import ru.geekbrains.spring_less_Boot.many_to_many.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);

    List<Product> findAll();

    Product findByTitleProduct(String title);

    void save(Product product);

    void update(Long id, String title);

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
