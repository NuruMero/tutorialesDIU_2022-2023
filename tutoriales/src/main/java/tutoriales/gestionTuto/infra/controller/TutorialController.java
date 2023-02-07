package tutoriales.gestionTuto.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import tutoriales.gestionTuto.application.service.TutorialService;
import tutoriales.gestionTuto.domain.dto.TutorialesCreator;

@RestController
public class TutorialController implements TutorialAPI {
    @Autowired
    private TutorialService tutoService;

    @Override
    public ResponseEntity<?> findAll() {
        return tutoService.findAll();
    }

    @Override
    public ResponseEntity<?> getTutorialById(String id) {
        return tutoService.getTutorialById(id);
    }

    @Override
    public ResponseEntity<?> findByTitleContaining(String text) {
        return tutoService.findByTitleContaining(text);
    }

    @Override
    public ResponseEntity<?> findByPublished() {
        return tutoService.findByPublished();
    }

    @Override
    public ResponseEntity<?> newTutorial(TutorialesCreator newData) {
        return tutoService.newTutorial(newData);
    }

    @Override
    public ResponseEntity<?> updateTutorial(TutorialesCreator editData, String id) {
        return tutoService.updateTutorial(editData, id);
    }

    @Override
    public ResponseEntity<?> deleteTutorial(String id) {
        return tutoService.deleteTutorial(id);
    }

    @Override
    public ResponseEntity<?> deleteAllTutorials() {
        return tutoService.deleteAllTutorials();
    }
}
