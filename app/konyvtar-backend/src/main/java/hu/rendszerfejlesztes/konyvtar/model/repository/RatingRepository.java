package hu.rendszerfejlesztes.konyvtar.model.repository;

import hu.rendszerfejlesztes.konyvtar.model.entity.library.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
