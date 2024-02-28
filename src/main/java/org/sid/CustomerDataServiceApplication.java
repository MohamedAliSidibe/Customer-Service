package org.sid;

import org.sid.entities.Customer;
import org.sid.mapper.CustomerMapper;
import org.sid.repository.CustomerRepository;
import org.sid.service.CustomerServi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class CustomerDataServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDataServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerMapper customerMapper, CustomerServi customerServi) {
		return args -> {

			for (int i = 0; i <10;i++) {
				customerServi.customersave(customerMapper.fromEntity(
						Customer.builder()
								.name("Momo")
								.email("momojr59@gmail.com")
								.build()
				));
			}

			//Optional<Customer> customer= customerRepository.findById(1L);

			//System.out.println("momo"+customer);
		};

	}




}
