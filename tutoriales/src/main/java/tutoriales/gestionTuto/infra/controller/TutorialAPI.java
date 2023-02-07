package tutoriales.gestionTuto.infra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tutoriales.gestionTuto.domain.dto.TutorialesCreator;
import tutoriales.shared.config.EndpointUrls;

@CrossOrigin
@RequestMapping(EndpointUrls.Base)
public interface TutorialAPI {

    //GET HTTP requests
    @GetMapping
    public ResponseEntity<?> findAll();

    @GetMapping(EndpointUrls.requiresID)
    public ResponseEntity<?> getTutorialById(@PathVariable String id);

    @GetMapping(EndpointUrls.requiresText)
    public ResponseEntity<?> findByTitleContaining(@PathVariable("title") String title);

    @GetMapping(EndpointUrls.published)
    public ResponseEntity<?> findByPublished();

    //POST HTTP requests
    @PostMapping
    public ResponseEntity<?> newTutorial(@RequestBody TutorialesCreator newData);

    //PUT HTTP requests
    @PutMapping(EndpointUrls.requiresID)
    public ResponseEntity<?> updateTutorial(@RequestBody TutorialesCreator editData, @PathVariable String id);

    //DELETE HTTP requests
    @DeleteMapping(EndpointUrls.requiresID)
    public ResponseEntity<?> deleteTutorial(@PathVariable String id);

    @DeleteMapping
    public ResponseEntity<?> deleteAllTutorials();
}
