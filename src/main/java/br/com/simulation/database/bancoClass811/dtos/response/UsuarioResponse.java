package br.com.simulation.database.bancoClass811.dtos.response;

import br.com.simulation.database.bancoClass811.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor

public class UsuarioResponse {
    private UUID id;
    private String cpf;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.cpf = usuario.getCpf();
        this.dataCriacao = usuario.getDataCriacao();
        this.nome = usuario.getNome();
        this.dataAtualizacao = usuario.getDataAtualizacao();
    }

    public static List<UsuarioResponse> toResponse(List<Usuario> usuarios){
        return  usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }
}