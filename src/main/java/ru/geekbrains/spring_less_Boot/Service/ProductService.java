package ru.geekbrains.spring_less_Boot.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_Boot.Model.Product;
import ru.geekbrains.spring_less_Boot.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void changeCost(Long id, Integer cost) {
        Product product = repository.findById(id);
        product.setCost(product.getCost() + cost);
        // repository.save(product);
    }
}
