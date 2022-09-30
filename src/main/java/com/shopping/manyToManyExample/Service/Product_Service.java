package com.shopping.manyToManyExample.Service;

import com.shopping.manyToManyExample.Entity.Customer;
import com.shopping.manyToManyExample.Entity.Product;
import com.shopping.manyToManyExample.Repository.Product_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_Service {
    @Autowired
    private Product_Repo prepo;
    //create
    public Product saveProduct(Product product){
        return prepo.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return prepo.saveAll(products);
    }

    //retrieve
    public List<Product> findProducts(){
        return prepo.findAll();
    }
    public Product findProductById(int id){
        return prepo.findById(id).orElse(null);
    }
    public List<Product> findProductByName(String name){
        return prepo.findByPnameContaining(name);
    }
    public List<Product> findProductsLessThan(long price){
        return prepo.findByPriceLessThan(price);
    }

    //update
    public Product updateProduct(Product product){
        Product existing = prepo.findById(product.getPid()).orElse(null);
        existing.setPname(product.getPname());
        existing.setPrice(product.getPrice());
        return prepo.save(existing);
    }

    //delete
    public String deleteProductById(int id){
        prepo.deleteById(id);
        return "product deleted with id: "+id;
    }

}
