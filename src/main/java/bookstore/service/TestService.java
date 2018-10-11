package bookstore.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;

import bookstore.model.Customer;
import bookstore.repositories.CustomerRepository;

@Service
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    @Value("${bookstore.hello.world}")
    private String program;

    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void saveCustomerEntities() {
        System.out.println(program);
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));
        logger.info("Entites saved into DB!");
    }

    public List<Customer> listCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            customers.add(customer);
        }
        return customers;
    }

    public Collection<Customer> listCustomCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            return Lists.newArrayList(customerRepository.findAll());
        } else {
            return customerRepository.findByLastNameStartsWithIgnoreCase(filterText);
        }
    }

    public void addCustomer() {
        System.out.println("New Customer added");
    }
}
