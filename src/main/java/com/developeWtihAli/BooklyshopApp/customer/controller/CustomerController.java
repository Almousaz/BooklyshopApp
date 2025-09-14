package com.developeWtihAli.BooklyshopApp.customer.controller;


import com.developeWtihAli.BooklyshopApp.customer.entity.Customer;
import com.developeWtihAli.BooklyshopApp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/auth")
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @PostMapping("/createcustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer saved = customerService.addCustomer(customer);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/getallcustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/getcustomerbyid/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable String customerId) {
        Optional<Customer> customerOpt = customerService.getCustomerById(customerId);
        if (customerOpt.isPresent()) {
            return ResponseEntity.ok(customerOpt.get());
        } else {
            return ResponseEntity.status(404).body("Customer not found");
        }
    }


    @PutMapping("/updatecustomer/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        Customer updated = customerService.updateCustomer(customerId, customer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.status(404).body("Customer not found");
    }

    // ✅ Delete customer
    @DeleteMapping("/deletecustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted");
    }

}
