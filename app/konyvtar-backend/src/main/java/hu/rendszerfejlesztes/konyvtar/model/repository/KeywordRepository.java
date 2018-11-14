package hu.rendszerfejlesztes.konyvtar.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.rendszerfejlesztes.konyvtar.model.entity.library.Keyword;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    
    Keyword findFirstById(Long id);
    
    List<Keyword> findAll();
}
