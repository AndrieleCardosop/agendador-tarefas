package com.andriele.agendadortarefas.infrastructure.security;


import com.andriele.agendadortarefas.business.DTO.UsuarioDTO;
import com.andriele.agendadortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

@Autowired
private UsuarioClient client;

    public UserDetails carregaDadosUsuario (String email, String token){
        UsuarioDTO usuarioDTO= client.buscausuarioPorEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha())
                .build();

    }
}
