package com.developeWtihAli.BooklyshopApp.customer.serviceImpl;

import com.developeWtihAli.BooklyshopApp.customer.entity.Customer;
import com.developeWtihAli.BooklyshopApp.customer.repository.CustomerRepository;
import com.developeWtihAli.BooklyshopApp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer addCustomer(Customer customer) {
        customer.setStatus("PENDING");
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(String customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(String customerId, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);
        if (existingCustomer.isPresent()) {
            Customer custToUpdate = existingCustomer.get();
            if (customer.getCustomerName() != null) custToUpdate.setCustomerName(customer.getCustomerName());
            if (customer.getCustomerEmail() != null) custToUpdate.setCustomerEmail(customer.getCustomerEmail());
            if (customer.getAddress() != null) custToUpdate.setAddress(customer.getAddress());
            if (customer.getStatus() != null) custToUpdate.setStatus(customer.getStatus());
            if (customer.getUserName() != null) custToUpdate.setUserName(customer.getUserName());
            if (customer.getPassword() != null) custToUpdate.setPassword(customer.getPassword());
            if (customer.getCustomerPhone() != null) custToUpdate.setCustomerPhone(customer.getCustomerPhone());
            if (customer.getProfileImage() != null) custToUpdate.setProfileImage(customer.getProfileImage());
            return customerRepository.save(custToUpdate);
        } else {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }
    }

    @Override
    public Customer updateProfileImage(String customerId, String profileImage) {
        return null;
    }

    @Override
    public boolean existsByUserName(String userName) {
        return false;
    }

    @Override
    public Customer verifyCustomer(String customerId) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setStatus("VERIFIED");
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }
    }

    @Override
    public void generateResetCode(String userName, String email) {

    }

    @Override
    public boolean verifyResetCode(String userName, String code) {
        return false;
    }

    @Override
    public void resetPasswordWithCode(String userName, String code, String newPassword) {

    }
}
