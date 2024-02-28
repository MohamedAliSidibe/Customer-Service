package org.sid.web;

import lombok.AllArgsConstructor;
import org.sid.dto.CustomerDto;
import org.sid.entities.Customer;
import org.sid.repository.CustomerRepository;
import org.sid.service.CustomerServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class CustomerRestController implements CustomerRestControllerInter {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerServi customerService;

    @Override
    public Page<Customer> listpage(int page, int size, String mc) {
        Page<Customer> custo=customerRepository.findByNameContains(mc, PageRequest.of(page, size));
        System.out.println(new int[custo.getTotalPages()].length);
        System.out.println(page);
        System.out.println(mc);
        System.out.println(size);
        System.out.println(custo.getContent());
        return custo;
    }

    @Override
    public List<CustomerDto> customerList()
    {
        return customerService.customerList();
    }

    @Override
    public CustomerDto customerById(Long id) {

        return customerService.customerById(id);
    }


    @Override
    public CustomerDto saveCustomer(CustomerDto customer) {
        return customerService.customersave(customer);
    }
}
