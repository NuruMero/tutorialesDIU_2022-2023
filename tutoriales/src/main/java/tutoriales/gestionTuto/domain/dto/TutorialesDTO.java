package tutoriales.gestionTuto.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TutorialesDTO {

    @Id
    private String ID;
    private String title;
    private String description;
    private Boolean published;
}
