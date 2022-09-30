package com.shopping.manyToManyExample.Controller;

import com.shopping.manyToManyExample.Entity.Customer;
import com.shopping.manyToManyExample.Service.Customer_Service;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Customer_Controller {

    @Autowired
    Customer_Service cservice;
    /*
    SWAGGER ANNOTAIONS USED HERE:
    @ApiOperation - used to describe a single operation, value contains operation's summary field
    @ApiParam - to add more details about parameter, helps to specify name,type,description,example value
    * */
    @PostMapping("/customers/save")
    public Customer addCustomer(@RequestBody Customer customer){
        return cservice.saveCustomer(customer);
    }
    @GetMapping("/customers")
    public List<Customer> findAllCustomers(){
        return cservice.getCustomers();
    }
    @GetMapping("/customers/{id}")
    @ApiOperation(value="finds a customer by its id",
    notes = "provide an id",response = Customer.class)
    public Customer findCustomerById(@ApiParam(value="Id value of the customer you need to retrieve",required = true) @PathVariable int id){
        return cservice.getCustomerById(id);
    }
    @PutMapping("/customers/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return cservice.updateCustomer(customer);
    }
    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id){
        return cservice.deleteCustomerById(id);
    }






}
