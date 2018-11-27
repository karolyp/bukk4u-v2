package hu.rendszerfejlesztes.konyvtar.rest;

import hu.rendszerfejlesztes.konyvtar.model.entity.library.Rating;
import hu.rendszerfejlesztes.konyvtar.model.repository.BookRepository;
import hu.rendszerfejlesztes.konyvtar.model.repository.RatingRepository;
import hu.rendszerfejlesztes.konyvtar.model.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RatingController {

    private BookRepository bookRepository;
    private UserRepository userRepository;
    private RatingRepository ratingRepository;
    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    public RatingController(BookRepository bookRepository, UserRepository userRepository, RatingRepository ratingRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.ratingRepository = ratingRepository;
    }

    @PostMapping(value = "/rating")
    @ResponseBody
    public ResponseEntity<?> saveRating(@RequestBody Rating.DTO dto) {
        logger.info(dto.toString());
        Rating rating = new Rating();
        rating.setStars(dto.getStars());
        rating.setTextRating(dto.getTextRating());
        rating.setBook(bookRepository.findById(dto.getBookId()).get());
        rating.setDate(dto.getDate());
        rating.setUser(userRepository.findOneByUsername(dto.getUsername()));
        return ResponseEntity.ok(ratingRepository.save(rating));

    }

}
