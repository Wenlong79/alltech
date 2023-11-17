package com.wl.controller;

import com.wl.request.CreateCustomerRequest;
import com.wl.response.CustomerResponse;
import com.wl.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public CustomerResponse createDepartment(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest);
    }

    @GetMapping("/getById/{id}")
    public CustomerResponse getById(@PathVariable long id) {
        return customerService.getById(id);
    }
}
