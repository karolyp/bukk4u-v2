package hu.rendszerfejlesztes.konyvtar.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hu.rendszerfejlesztes.konyvtar.model.entity.library.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT b.categories FROM Book b WHERE b.id = :id")
    List<Category> getCategoriesByBookId(@Param("id") long id);
    
    Category findFirstById(Long id);
    
    List<Category> findAll();
}
