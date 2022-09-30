package com.shopping.manyToManyExample.Service;

import com.shopping.manyToManyExample.Entity.Customer;
import com.shopping.manyToManyExample.Repository.Customer_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Customer_Service {
    @Autowired
    private Customer_Repo crepo;

    //create
    public Customer saveCustomer(Customer customer){
        return crepo.save(customer);
    }
    //retrieve
    public List<Customer> getCustomers(){
        return crepo.findAll();
    }

    public Customer getCustomerById(int id){
        return crepo.findById(id).orElse(null);
    }
    //update
    public Customer updateCustomer(Customer customer){
        Customer existing = crepo.findById(customer.getCid()).orElse(null);
        existing.setCname(customer.getCname());
        return crepo.save(existing);
    }
    //delete
    public String deleteCustomerById(int id){
        crepo.deleteById(id);
        return "deleted customer with id: "+id;
    }





}
