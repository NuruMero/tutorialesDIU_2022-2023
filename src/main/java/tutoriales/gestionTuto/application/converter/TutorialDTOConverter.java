package tutoriales.gestionTuto.application.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import tutoriales.gestionTuto.domain.TutorialesVO;
import tutoriales.gestionTuto.domain.dto.TutorialesCreator;
import tutoriales.gestionTuto.domain.dto.TutorialesDTO;

@Component
@RequiredArgsConstructor
public class TutorialDTOConverter {

    private final ModelMapper modelMapper;

    public TutorialesVO fromDTOtoVO(TutorialesDTO dto) {
        return modelMapper.map(dto, TutorialesVO.class);
    }

    public TutorialesDTO fromVOtoDTO(TutorialesVO vo) {
        return modelMapper.map(vo, TutorialesDTO.class);
    }

    public TutorialesVO fromCreatorToVO(TutorialesCreator creator) {
        return modelMapper.map(creator, TutorialesVO.class);
    }
}
