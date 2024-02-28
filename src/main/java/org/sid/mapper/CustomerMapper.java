package org.sid.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.customerdataservice.stub.CustomerServiceOuterClass;
import org.sid.dto.CustomerDto;
import org.sid.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    CustomerDto fromEntity(Customer customer);
    Customer toEntity(CustomerDto customerdto);
    CustomerServiceOuterClass.Customer fromCustomer(CustomerDto customerdto);
    CustomerDto fromGrpCustomerDto(CustomerServiceOuterClass.CustomerDto customerRequest);
}
