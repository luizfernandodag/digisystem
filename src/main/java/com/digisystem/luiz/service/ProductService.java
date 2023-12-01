package com.digisystem.luiz.service;

import com.digisystem.luiz.model.Product;
import com.digisystem.luiz.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    @Transactional
    public void update(Long id, Product updatedProd) {
        productRepository
                .findById(id)
                .ifPresent(prod -> {
                    prod.setName(updatedProd.getName());
                    prod.setPrice(updatedProd.getPrice());


                    productRepository.save(prod);
                });
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
