package com.andriele.agendadortarefas.business;

import com.andriele.agendadortarefas.business.DTO.TarefasDTO;
import com.andriele.agendadortarefas.business.mapper.TarefasConverter;
import com.andriele.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.andriele.agendadortarefas.infrastructure.enums.StatusNotificacao;
import com.andriele.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.andriele.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacao.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return  tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
