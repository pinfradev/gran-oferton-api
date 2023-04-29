package com.gran.oferton.granoferton.modules.products.web;

import com.gran.oferton.granoferton.modules.products.domain.dto.Product;
import com.gran.oferton.granoferton.modules.products.domain.dto.ProductFailureResponse;
import com.gran.oferton.granoferton.modules.products.domain.dto.ProductResponse;
import com.gran.oferton.granoferton.modules.products.domain.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        try {
            int id = Double.valueOf(Math.random() * 30000).intValue();
            product.setId(String.valueOf(id));
            Product createdProduct = productsService.saveProduct(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable(name = "id") String productId) {
        try {
            Product product = productsService.getProductById(productId);
            return new ResponseEntity(product, HttpStatus.OK);
        } catch (Exception exception) {
            ProductFailureResponse response = new ProductFailureResponse("error", "no se encontró el producto con id " + productId);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/modify")
    public ResponseEntity<ProductResponse> modifyProduct(@RequestBody Product product) {
        if (productsService.isProductPresent(product.getId())) {
            try {
                Product createdProduct = productsService.saveProduct(product);
                return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
            } catch (Exception e) {
                ProductFailureResponse response = new ProductFailureResponse("error", "Ha ocurrido un error inesperado");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        ProductFailureResponse response = new ProductFailureResponse("error", "id no encontrado");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PatchMapping(path = "/modify/{id}")
    public ResponseEntity modifyProductActiveState(@RequestParam(name = "is_active") boolean isActive, @PathVariable String id) {
        if (!productsService.isProductPresent(id)) {
            return new ResponseEntity<>(new ProductFailureResponse("error", "id no encontrado"), HttpStatus.NOT_FOUND);
        }
        try {
            int affectedRows = productsService.updateProduct(isActive, id);
            return new ResponseEntity(Map.of(
                    "affected rows", affectedRows
            ), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity(Map.of(
                    "error", "ocurrio un error inesperado"
            ), HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
        if (!productsService.isProductPresent(id)) {
            return new ResponseEntity<>(new ProductFailureResponse("error", "id no encontrado"), HttpStatus.NOT_FOUND);
        }

        productsService.deleteProduct(id);
        return new ResponseEntity(Map.of(
                "message", "deleted successfully"
        ),HttpStatus.OK);
    }
}
