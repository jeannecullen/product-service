//package com.solstice.cloud;
//
//import com.solstice.cloud.controller.ProductController;
//import com.solstice.cloud.domain.Product;
//import com.solstice.cloud.repo.ProductRepository;
//import com.solstice.cloud.service.ProductService;
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static java.util.Collections.singletonList;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.hamcrest.Matchers.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ProductRepositoryTest {
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    TestEntityManager entityManager;
//
//    @Test
//    public void testGetProduct() {
//        Product newProduct = new Product();
//        newProduct.setProductId(10L);
//        entityManager.persistAndFlush(newProduct);
//
//        Iterable <Product> products = productRepository.findAll();
//        Optional<Product> expected = productRepository.findById(10L);
//
//        assertThat(newProduct.getProductId()).isEqualTo(10L);
//
//    }
//}
