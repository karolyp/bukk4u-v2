package hu.rendszerfejlesztes.konyvtar.rest;

import java.util.List;
import java.util.Optional;

import hu.rendszerfejlesztes.konyvtar.exception.KonyvtarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hu.rendszerfejlesztes.konyvtar.model.entity.library.Book;
import hu.rendszerfejlesztes.konyvtar.model.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    BookRepository bookRepository;

    @PostMapping(path = "/book")
    @ResponseBody
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        log.info("Incoming BookSave request.");
        ResponseEntity<Book> response;
        if (bookRepository.existsById(book.getId())) {
            response = ResponseEntity.badRequest().body(book);
        }
        response = ResponseEntity.ok(bookRepository.save(book));

        return response;
    }

    @GetMapping(path = "/book")
    @ResponseBody
    public ResponseEntity<List<Book>> listBook() {
        log.info("Incoming BookList request.");
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping(path = "/book/{id}")
    @ResponseBody
    public ResponseEntity<?> findBook(@PathVariable Long id) {
        ResponseEntity<?> response;
        log.info("Incoming BookList request.");
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            response = ResponseEntity.ok(book.get());
        } else {
            response = ResponseEntity.badRequest().body("Ilyen azonosítójú könyv nem létezik!");
        }

        return response;
    }

    @DeleteMapping(path = "/book/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        log.info("Incoming BookDelete request.");
        ResponseEntity<?> response;
        if (bookRepository.existsById(id)) {
            response = ResponseEntity.badRequest().body(bookRepository.findById(id));
        }
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Deleted Book with ID: " + id);
    }
}
