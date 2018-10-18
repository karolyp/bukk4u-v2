package hu.rendszerfejlesztes.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.rendszerfejlesztes.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
