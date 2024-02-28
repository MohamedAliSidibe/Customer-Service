package org.sid.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.sid.dto.CustomerDto;
import org.sid.entities.Customer;
import org.sid.mapper.CustomerMapper;
import org.sid.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImple implements CustomerServi {

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private  CustomerMapper customerMapper;


    /*@Autowired
    public CustomerServiceImple(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }*/

    @Override
    public CustomerDto customersave(CustomerDto customer) {

        if(Objects.isNull(customer)){
            throw new RuntimeException("customer isnot found");
        }
        return customerMapper.fromEntity(
                customerRepository.save
                        (customerMapper.toEntity(customer)
                        ));
    }

    @Override
    public List<CustomerDto> customerList() {
        List<CustomerDto> customerDtoList= customerRepository.findAll()
                .stream()
                .map(data->customerMapper.fromEntity(data))
                .collect(Collectors.toList());
        if(customerDtoList.isEmpty()){
            throw new RuntimeException("liste vide");
        }
        return customerDtoList;
    }

    @Override
    public CustomerDto customerById(Long id) {
        Optional<Customer> customer= customerRepository.findById(id);
        if(!customer.isPresent()){
            throw new EntityNotFoundException("Customer not found");
        }
        return Optional.of(customerMapper.fromEntity(customer.get()))
                .orElseThrow(
                        ()->new EntityNotFoundException("Customer not found")
                );


    }
}
