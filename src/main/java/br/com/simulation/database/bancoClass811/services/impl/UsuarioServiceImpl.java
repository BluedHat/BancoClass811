package br.com.simulation.database.bancoClass811.services.impl;

import br.com.simulation.database.bancoClass811.dtos.request.UsuarioRequest;
import br.com.simulation.database.bancoClass811.dtos.response.UsuarioResponse;
import br.com.simulation.database.bancoClass811.models.Usuario;
import br.com.simulation.database.bancoClass811.repositories.UsuarioRepository;
import br.com.simulation.database.bancoClass811.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service

public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll(String nome, int page, int size) {

        if (nome != null) {
            return (List<Usuario>) usuarioRepository.findByNome(nome);
        } else {
            return usuarioRepository.findAll();
        }
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest);
        usuario.setLogin(usuarioRequest.getLogin());
        usuario.setDataAtualizacao(LocalDateTime.now());
        usuario.setDataCriacao(LocalDateTime.now());

        usuarioRepository.save(usuario);

        return new UsuarioResponse(usuario);
    }

    @Override
    public Usuario getById(UUID id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public Usuario update(UsuarioRequest usuarioRequest, UUID id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setLogin(usuarioRequest.getLogin());
        usuario.setDataAtualizacao(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(UUID id) {
        var usuario = usuarioRepository.findById(id).orElseThrow();

        usuarioRepository.delete(usuario);
    }
}