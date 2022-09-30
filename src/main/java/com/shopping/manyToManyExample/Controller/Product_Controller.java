package com.shopping.manyToManyExample.Controller;

import com.shopping.manyToManyExample.Entity.Product;
import com.shopping.manyToManyExample.Service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Product_Controller {
    @Autowired
    Product_Service pservice;
    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product){
        return pservice.saveProduct(product);
    }
    @PostMapping("/products/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return pservice.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return pservice.findProducts();
    }
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable int id){
        return pservice.findProductById(id);
    }
    @GetMapping("/products/name/{name}")
    public List<Product> findProductsByName(@PathVariable String name){
        return pservice.findProductByName(name);
    }
    @GetMapping("/products/lessThan/{price}")
    public List<Product> findProductsLessThan(@PathVariable long price){
        return pservice.findProductsLessThan(price);
    }
    @PutMapping("/products/update")
    public Product updateProduct(@RequestBody Product product){ return pservice.updateProduct(product);}
    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable int id){
        return pservice.deleteProductById(id);
    }
}
