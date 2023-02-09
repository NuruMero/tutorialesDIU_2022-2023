package tutoriales.gestionTuto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class TutorialesVO {

    @Id
    private String ID;
    private String title;
    private String description;
    private Boolean published;
}