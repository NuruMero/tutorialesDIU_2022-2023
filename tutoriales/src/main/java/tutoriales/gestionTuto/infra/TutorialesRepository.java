package tutoriales.gestionTuto.infra;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tutoriales.gestionTuto.domain.TutorialesVO;

@Repository
public interface TutorialesRepository extends MongoRepository<TutorialesVO, String> {
}
