package br.com.simulation.database.bancoClass811.controllers;

import com.querydsl.core.types.Predicate;
import br.com.simulation.database.bancoClass811.dtos.request.UsuarioRequest;
import br.com.simulation.database.bancoClass811.dtos.response.UsuarioResponse;
import br.com.simulation.database.bancoClass811.models.Usuario;
import br.com.simulation.database.bancoClass811.repositories.UsuarioRepository;
import br.com.simulation.database.bancoClass811.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable UUID id) {
        return usuarioService.getById(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable UUID id, @RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.update(usuarioRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        usuarioService.delete(id);
    }
}
