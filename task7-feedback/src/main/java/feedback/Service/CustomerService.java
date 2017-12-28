/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.Service;

import feedback.Repository.CustomerRepository;
import org.springframework.stereotype.Service;
import feedback.Service.CustomerService;
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
