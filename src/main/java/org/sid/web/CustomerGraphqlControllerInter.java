package org.sid.web;

import org.sid.dto.CustomerDto;
import org.sid.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerGraphqlControllerInter {

   /* @GetMapping("/pagecustomer")
    public Page<Customer> listpage(@RequestParam(name="page",defaultValue = "0")int page,
                                   @RequestParam(name="size",defaultValue = "5")int size,
                                   @RequestParam(name="motcle",defaultValue = "")String mc);
    */
    @QueryMapping
    public List<CustomerDto> customerList();
    @QueryMapping
    public CustomerDto customerById(@Argument Long id);
    @MutationMapping
    public CustomerDto saveCustomer(@Argument CustomerDto customer);
}

