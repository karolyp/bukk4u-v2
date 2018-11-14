package hu.rendszerfejlesztes.konyvtar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hu.rendszerfejlesztes.konyvtar.model.entity.library.Category;
import hu.rendszerfejlesztes.konyvtar.model.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@PostMapping(path = "/category")
    @ResponseBody
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        log.info("Incoming CategorySave request.");
        ResponseEntity<Category> response;
        if(categoryRepository.existsById(category.getId())) {
        	response = ResponseEntity.badRequest().body(category);
        }
        response = ResponseEntity.ok(categoryRepository.save(category));

        return response;
    }
	
	@GetMapping(path = "/category")   
    public @ResponseBody ResponseEntity<List<Category>> listCategory() {
        log.info("Incoming CategoryList request.");
        return ResponseEntity.ok(categoryRepository.findAll());
    }
	
	@DeleteMapping(path = "/category/{id}")   
    public @ResponseBody ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        log.info("Incoming CategoryDelete request.");
        ResponseEntity<?> response;
        if(categoryRepository.existsById(id)) {
        	response = ResponseEntity.badRequest().body(categoryRepository.findById(id));
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.ok("Deleted Category with ID: " + id);
    }
}
