package bookstore.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import bookstore.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByLastNameStartsWithIgnoreCase(String text);
}
