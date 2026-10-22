package com.andriele.agendadortarefas.business.mapper;

import com.andriele.agendadortarefas.business.DTO.TarefasDTO;
import com.andriele.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
