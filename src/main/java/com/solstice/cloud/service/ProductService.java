package com.solstice.cloud.service;

import com.solstice.cloud.domain.Product;
import com.solstice.cloud.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger("ProductService");

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        Product productSaved = productRepository.save(product);
        return productSaved;
    }

    public Optional<Product> getProduct(Long productId) {
        return productRepository.findById(productId);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
