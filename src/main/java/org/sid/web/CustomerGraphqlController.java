package org.sid.web;

import org.antlr.v4.runtime.misc.NotNull;
import org.sid.dto.CustomerDto;
import org.sid.entities.Customer;
import org.sid.repository.CustomerRepository;
import org.sid.service.CustomerServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class CustomerGraphqlController implements CustomerGraphqlControllerInter{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerServi customerService;
    @Override
    public List<CustomerDto> customerList() {

        return customerService.customerList();
    }

    @Override
    public CustomerDto customerById(Long id) {
        return customerService.customerById(id);
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customer) {
        if(Objects.isNull(customer)){
            throw new RuntimeException("");
        }
        return customerService.customersave(customer);
    }
}
