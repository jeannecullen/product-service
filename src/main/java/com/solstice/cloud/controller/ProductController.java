package com.solstice.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.solstice.cloud.domain.Product;
import com.solstice.cloud.repo.ProductRepository;
import com.solstice.cloud.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger("ProductController");

    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    @HystrixCommand(fallbackMethod = "createProductFallback")
    @ResponseBody
    public Product createProduct(@RequestBody Product product) {
        Product productSaved = productService.save(product);
        logger.info("Product saved: " +productSaved.getProductId());
        return product;
    }


    @GetMapping("/product/{productId}")
    @HystrixCommand(fallbackMethod = "getProductFallback")
    public Product getProduct(@PathVariable("productId") Long productId) {
        Optional <Product> productRetrieved = productService.getProduct(productId);
        Product product = productRetrieved.get();
        return product;
    }

    @PutMapping("/product/{productId}")
    @HystrixCommand(fallbackMethod = "updateProductFallback")
    public Product updateProduct(@RequestBody Product product) {
        Product productUpdated = productService.save(product);
        logger.info("Product saved: " +productUpdated.toString());
        return product;
    }

    @DeleteMapping("/product/{productId}")
    @HystrixCommand(fallbackMethod = "deleteProductFallback")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().body("Product has been deleted.");
    }

    public Product createProductFallback(Product product) {
        logger.error("Error creating product: " +product);
        return new Product();
    }

    public Optional<Product> getProductFallback(Long productId) {
        logger.error("Error creating Product with id " +productId);
        return Optional.of(new Product());
    }

    public Product updateProductFallback(Product product){
        logger.error("Error updating product " +product);
        return new Product();
    }

    public void deleteProductFallback(Long productId) {
        logger.info("Error while deleting product");
    }
}
