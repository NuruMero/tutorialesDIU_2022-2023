package tutoriales.gestionTuto.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tutoriales.gestionTuto.application.converter.TutorialDTOConverter;
import tutoriales.gestionTuto.application.service.TutorialService;
import tutoriales.gestionTuto.domain.TutorialesVO;
import tutoriales.gestionTuto.domain.dto.TutorialesCreator;
import tutoriales.gestionTuto.domain.dto.TutorialesDTO;
import tutoriales.gestionTuto.infra.TutorialesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    private TutorialesRepository tutoRepo;

    @Autowired
    private TutorialDTOConverter tutoConverter;

    @Override
    public ResponseEntity<?> findAll() {
        List<TutorialesVO> tutolist= tutoRepo.findAll();
        if (tutolist.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<TutorialesDTO> dtoList = tutolist.stream().map(tutoConverter::fromVOtoDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @Override
    public ResponseEntity<?> getTutorialById(String id) {
        TutorialesVO tuto = tutoRepo.findById(id).orElse(null);
        if (tuto == null) {
            return ResponseEntity.notFound().build();
        } else {
            TutorialesDTO dto = tutoConverter.fromVOtoDTO(tuto);
            return ResponseEntity.ok(dto);
        }
    }

    @Override
    public ResponseEntity<?> findByTitleContaining(String text) {
        List<TutorialesVO> list = tutoRepo.findAll();
        List<TutorialesVO> uselist = new ArrayList<>();
        list.stream().filter(Objects::nonNull)
                .forEach(tuto -> {
                    if (tuto.getTitle().toLowerCase().contains(text.toLowerCase())) {
                        uselist.add(tuto);
                    }
                });
        if (uselist.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(uselist);
        }
    }

    @Override
    public ResponseEntity<?> findByPublished() {
        List<TutorialesVO> list = tutoRepo.findAll();
        List<TutorialesVO> uselist = new ArrayList<>();
        list.stream().filter(Objects::nonNull)
                .forEach(tuto -> {
                    if (tuto.getPublished()) {
                        uselist.add(tuto);
                    }
                });
        if (uselist.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(uselist);
        }
    }

    @Override
    public ResponseEntity<?> newTutorial(TutorialesCreator creator) {
        TutorialesVO tutoNuevo = tutoConverter.fromCreatorToVO(creator);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutoRepo.save(tutoNuevo));
    }

    @Override
    public ResponseEntity<?> updateTutorial(TutorialesCreator creator, String id) {
        return tutoRepo.findById(id).map(tuto -> {
            tuto = tutoConverter.fromCreatorToVO(creator);
            tuto.setID(id);
            return ResponseEntity.ok((tutoRepo.save(tuto)));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> deleteTutorial(String id) {
        tutoRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> deleteAllTutorials() {
        tutoRepo.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
