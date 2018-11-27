package hu.rendszerfejlesztes.konyvtar.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hu.rendszerfejlesztes.konyvtar.model.entity.library.Keyword;
import hu.rendszerfejlesztes.konyvtar.model.repository.KeywordRepository;

@RestController
public class KeywordController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	KeywordRepository keywordRepository;
	
	@PostMapping(path = "/keyword")
    @ResponseBody
    public ResponseEntity<Keyword> saveKeyword(@RequestBody Keyword keyword) {
        log.info("Incoming KeywordSave request.");
        ResponseEntity<Keyword> response;
        if(keywordRepository.existsById(keyword.getId())) {
        	response = ResponseEntity.badRequest().body(keyword);
        }
        response = ResponseEntity.ok(keywordRepository.save(keyword));

        return response;
    }
	
	@GetMapping(path = "/keyword")   
    public @ResponseBody ResponseEntity<List<Keyword>> listKeyword() {
        log.info("Incoming KeywordList request.");
        return ResponseEntity.ok(keywordRepository.findAll());
    }
	
	@DeleteMapping(path = "/keyword/{id}")   
    public @ResponseBody ResponseEntity<?> deleteKeyword(@PathVariable("id") Long id) {
        log.info("Incoming KeywordDelete request.");
        ResponseEntity<?> response;
        if(keywordRepository.existsById(id)) {
        	response = ResponseEntity.badRequest().body(keywordRepository.findById(id));
        }
        keywordRepository.deleteById(id);
        return ResponseEntity.ok("Deleted Keyword with ID: " + id);
    }
}
