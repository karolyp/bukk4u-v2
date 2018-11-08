package hu.rendszerfejlesztes.konyvtar.model.repository;

import hu.rendszerfejlesztes.konyvtar.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
