package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController
{
    @Autowired
    CustomerRepository customerrepos;

    @GetMapping("/customer")
    public List<Customer> allCustomers()
    {
        return customerrepos.findAll();
    }

//customer/order - Returns all customers with their orders
    @GetMapping("/customer/order")
    public List<Object[]> findCustomersAndOrders()
    {
        return customerrepos.findCustomersAndOrders();
    }

    // DOESN'T WORK YET!!!
//customer/name/{custname} - Returns all orders for a particular based on name
    @GetMapping("/customer/name/{custname}")
    public List<Object[]> findCustomerOrdersByName(@PathVariable String custname)
    {
        return customerrepos.findByCustName(custname);
    }

//customer/order/{custcode} - Returns all orders for a particular customer based on custcode
    @GetMapping("/customer/order/{custcode}")
    public List<Object[]> findCustOrdersByCustCode(@PathVariable long custcode)
    {
        return customerrepos.findCustOrdersByCustCode(custcode);
    }

    // Does not work comepletely!!!  It will only delete customers with no orders.
//customer/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders
    @DeleteMapping("/customer/{custcode}")
    public void deleteByCustCode(@PathVariable long custcode)
    {
        customerrepos.deleteById(custcode);
    }



    // simon
    @GetMapping("/customer/name2/{custname}")
    public List<Object[]> getCustomerByNameWithAllOrders(@PathVariable String custname) {
        return customerrepos.findCustomerByNameWithOrders(custname);
    }
}

