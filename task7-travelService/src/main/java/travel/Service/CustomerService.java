/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.Service;

import travel.Repository.CustomerRepository;
import org.springframework.stereotype.Service;
import travel.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author aveli
 */

@Service
public class CustomerService  {
    
    private final CustomerRepository customerRepository;
    
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    
}
