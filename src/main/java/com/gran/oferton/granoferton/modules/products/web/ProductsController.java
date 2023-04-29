package com.gran.oferton.granoferton.modules.products.web;

import com.gran.oferton.granoferton.modules.products.domain.dto.Product;
import com.gran.oferton.granoferton.modules.products.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductsController {

    private ProductService productsService;

    @Autowired
    public ProductsController(ProductService productsService){
        System.out.println("init");
        this.productsService = productsService;
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productsService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(path="/save")
    public ResponseEntity<Product> saveProduct() {
        Product product = new Product();
        product.setProductName("mi nombre");
        System.out.println("entoooooo");
        return new ResponseEntity(product,HttpStatus.BAD_REQUEST);
    }
}
