package br.com.simulation.database.bancoClass811.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioRequest {
    private String cpf;
    private String nome;
    private String senha;
    private String login;
}
