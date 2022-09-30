package com.shopping.manyToManyExample.Repository;

import com.shopping.manyToManyExample.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product_Repo extends JpaRepository<Product,Integer> {
    public List<Product> findByPnameContaining(String name);
    public List<Product> findByPriceLessThan(long price);
}
