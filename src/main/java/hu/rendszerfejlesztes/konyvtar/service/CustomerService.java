package hu.rendszerfejlesztes.konyvtar.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.rendszerfejlesztes.konyvtar.model.Customer;
import hu.rendszerfejlesztes.konyvtar.model.repositories.CustomerRepository;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Collection<Customer> findByLastName(String filterText) {
        List<Customer> customers;

        if (filterText == null || filterText.isEmpty()) {
            customers = customerRepository.findAll();
        } else {
            customers = customerRepository.findByLastNameStartsWithIgnoreCase(filterText);
        }

        return customers;
    }

}
