package br.com.simulation.database.bancoClass811.services;

import br.com.simulation.database.bancoClass811.dtos.request.UsuarioRequest;
import br.com.simulation.database.bancoClass811.dtos.response.UsuarioResponse;
import br.com.simulation.database.bancoClass811.models.Usuario;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.UUID;

public interface UsuarioService {
        List<Usuario> getAll(String nome, int page, int size);
        UsuarioResponse create(UsuarioRequest usuarioRequest);
        Usuario getById(UUID id);
        Usuario update(UsuarioRequest usuarioRequest, UUID id);
        void delete(UUID id);
    }
