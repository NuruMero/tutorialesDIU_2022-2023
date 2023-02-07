package tutoriales.gestionTuto.application.service;

import org.springframework.http.ResponseEntity;
import tutoriales.gestionTuto.domain.dto.TutorialesCreator;

public interface TutorialService {

    public ResponseEntity<?> findAll();

    public ResponseEntity<?> getTutorialById(String id);

    public ResponseEntity<?> findByTitleContaining(String text);

    public ResponseEntity<?> findByPublished();

    public ResponseEntity<?> newTutorial(TutorialesCreator creator);

    public ResponseEntity<?> updateTutorial(TutorialesCreator creator, String id);

    public ResponseEntity<?> deleteTutorial(String id);

    public ResponseEntity<?> deleteAllTutorials();
}
