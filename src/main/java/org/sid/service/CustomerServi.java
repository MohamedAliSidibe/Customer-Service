package org.sid.service;

import org.sid.dto.CustomerDto;
import org.sid.entities.Customer;

import java.util.List;

public interface CustomerServi {
    public CustomerDto customersave(CustomerDto customer);
    public List<CustomerDto> customerList();
    public  CustomerDto customerById(Long id);
}
