package hu.rendszerfejlesztes.konyvtar.model.repository;

import hu.rendszerfejlesztes.konyvtar.model.entity.library.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findFirstByTitleGreaterThanOrderByTitleAsc(String title);

    Book findFirstByTitleLessThanOrderByTitleDesc(String title);
    

}
