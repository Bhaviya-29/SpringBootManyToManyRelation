package com.shopping.manyToManyExample.Repository;

import com.shopping.manyToManyExample.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_Repo extends JpaRepository<Customer,Integer> {
}
