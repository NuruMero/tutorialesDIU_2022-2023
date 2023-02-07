package tutoriales.gestionTuto.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutorialesCreator {
    private String ID;
    private String title;
    private String description;
    private Boolean published;
}
