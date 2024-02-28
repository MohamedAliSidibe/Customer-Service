package org.sid.web;

import org.sid.dto.CustomerDto;
import org.sid.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface CustomerRestControllerInter {

    @GetMapping("/pagecustomer")
    public Page<Customer> listpage(@RequestParam(name="page",defaultValue = "0")int page,
                                   @RequestParam(name="size",defaultValue = "5")int size,
                                   @RequestParam(name="motcle",defaultValue = "")String mc);
    @GetMapping("/customers")
    public List<CustomerDto> customerList();
    @GetMapping("/customers/{id}")
    public CustomerDto customerById(@PathVariable Long id);
    @PostMapping("/customers")
    public CustomerDto saveCustomer(@RequestBody CustomerDto customer);
}
