package com.shopping.manyToManyExample.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
/*
* SWAGGER ANNOTATIONS USED HERE:
* @ApiModel -- provides additional info about swagger models
* @ApiModelProperty -- provides additional info about model properties
* */
@ApiModel(description = "details about products available")
public class Product {
    @Id
    @GeneratedValue
    @ApiModelProperty(value="this is the unique id of product")
    private int pid;
    @ApiModelProperty(value="this is the name of the product")
    private String pname;
    @ApiModelProperty(value = "this is the price of the product")
    private long price;


    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Customer> customers;
}
