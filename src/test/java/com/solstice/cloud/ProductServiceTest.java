package com.solstice.cloud;

import com.solstice.cloud.domain.Product;
import com.solstice.cloud.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() {
        Product newProduct = new Product();
        newProduct.setProductName("Coffee");
        newProduct.setProductDescription("Dark Roast");
        newProduct.setProductImage("picture");
        newProduct.setProductPrice(2.00);

        Product test = productService.save(newProduct);

        assertNotNull(test);
        assertNotNull(test.getProductId());
        assertEquals("Coffee", test.getProductName());

    }

}
