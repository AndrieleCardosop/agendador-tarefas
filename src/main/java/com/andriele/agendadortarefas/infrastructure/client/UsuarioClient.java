package com.andriele.agendadortarefas.infrastructure.client;

import com.andriele.agendadortarefas.business.DTO.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {
    @GetMapping
    UsuarioDTO buscausuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);
}
