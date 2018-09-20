//package com.solstice.cloud.repo;
//
//import com.solstice.cloud.domain.Product;
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class ProductRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    public void testProduct() {
//        Product testProduct = new Product();
//        entityManager.persistAndFlush(testProduct);
//        Product foundProduct = productRepository.findById(6L);
//        assertThat(foundProduct.getProductId(), Matchers.is(Matchers.equalTo(Long.valueOf(1))));
//        this.entityManager.persist(new Product(2L, "gum", "minty", "picture",2.00 ));
//        Product product = this.productRepository.findById(6L);
//        assertThat(product.getProductId()).isEqualTo(6L);
//        assertThat(product.getProductName()).isEqualTo("gum");
//    }
//}