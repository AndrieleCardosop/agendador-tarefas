package com.andriele.agendadortarefas.business.mapper;

import com.andriele.agendadortarefas.business.DTO.TarefasDTO;
import com.andriele.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {
    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
