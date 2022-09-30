package com.shopping.manyToManyExample.Entity;

//import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Customer {
    @Id
    @GeneratedValue
    private int cid;
    private String cname;
    @ManyToMany(fetch = FetchType.LAZY) //cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_PRODUCT",
        joinColumns = {
                @JoinColumn(name = "customer_id",referencedColumnName = "cid")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "product_id", referencedColumnName = "pid")
        }
    )
    private List<Product> products;



}
