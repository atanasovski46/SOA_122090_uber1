package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by carbo on 3/7/17.
 */

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/getbyid")
    public Customer getById(@RequestParam(value="id", defaultValue = "-1") Long id) {
        Customer foundCustomer = customerRepository.findOne(id);

        return foundCustomer;
    }

    @RequestMapping("/createnew")
    public Customer createNew(@RequestParam(value="name") String name, @RequestParam(value="surname") String surname) {
        Customer newCustomer = new Customer(name, surname);

        customerRepository.save(newCustomer);

        return newCustomer;
    }

}
