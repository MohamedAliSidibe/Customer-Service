package org.sid.web;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.sid.customerdataservice.stub.CustomerServiceGrpc;
import org.sid.customerdataservice.stub.CustomerServiceOuterClass;
import org.sid.dto.CustomerDto;
import org.sid.entities.Customer;
import org.sid.mapper.CustomerMapper;
import org.sid.service.CustomerServi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class CustomerGrpcService extends CustomerServiceGrpc.CustomerServiceImplBase {

    @Autowired
    private CustomerServi customerServi;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void getAllCustomers(CustomerServiceOuterClass.GetAllCustomersRequest request, StreamObserver<CustomerServiceOuterClass.GetCustomersResponse> responseObserver) {
        List<CustomerServiceOuterClass.Customer> grpcCustomers = customerServi.customerList()
                .stream()
                .map(data->customerMapper.fromCustomer(data))
                .collect(Collectors.toList());

        CustomerServiceOuterClass.GetCustomersResponse customersResponse=CustomerServiceOuterClass.GetCustomersResponse

                .newBuilder()
                .addAllCustomers(grpcCustomers).build();

        System.out.println("momo");
       responseObserver.onNext(customersResponse);
       responseObserver.onCompleted();
    }

    @Override
    public void getCustomerById(CustomerServiceOuterClass.GetCustomerByIdRequest request, StreamObserver<CustomerServiceOuterClass.GetCustomersByIdResponse> responseObserver) {
        long customerId = request.getCustomerId();
        CustomerDto customerDto=customerServi.customerById(customerId);
        CustomerServiceOuterClass.GetCustomersByIdResponse response=
                CustomerServiceOuterClass.GetCustomersByIdResponse
                        .newBuilder()
                                .setCustomer(customerMapper.fromCustomer(customerDto))
                                        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void saveCustomer(CustomerServiceOuterClass.SaveCustomerRequest request, StreamObserver<CustomerServiceOuterClass.SaveCustomerResponse> responseObserver) {
        CustomerServiceOuterClass.CustomerDto customer = request.getCustomer();

        CustomerDto  customerDto=customerMapper.fromGrpCustomerDto(customer);
        CustomerDto customerDtosave=customerServi.customersave(customerDto);

        CustomerServiceOuterClass.SaveCustomerResponse response= CustomerServiceOuterClass.SaveCustomerResponse.newBuilder()
                .setCustomer(customerMapper.fromCustomer(customerDtosave))
                        .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
