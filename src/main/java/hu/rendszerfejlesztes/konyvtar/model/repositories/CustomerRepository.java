package hu.rendszerfejlesztes.konyvtar.model.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.rendszerfejlesztes.konyvtar.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByLastNameStartsWithIgnoreCase(String text);

    List<Customer> findAll();

}
