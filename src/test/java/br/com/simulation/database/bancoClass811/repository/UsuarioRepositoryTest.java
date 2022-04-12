package br.com.simulation.database.bancoClass811.repository;

import br.com.simulation.database.bancoClass811.models.Usuario;
import br.com.simulation.database.bancoClass811.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import java.util.List;

@DataJpaTest
@Profile("test")

public class UsuarioRepositoryTest {
    @Autowired private TestEntityManager entityManager;
    @Autowired UsuarioRepository usuarioRepository;

    @Test
    void validar_se_existem_usuarios_sem_id_no_banco(){
        List<Usuario>usuarios = usuarioRepository.findAll();
        Assertions.assertEquals(List.of(), usuarios);
    }

    @Test
    void inserir_novo_usuario_no_banco(){
        Usuario usuario1 = new Usuario();
        usuario1.setCpf("12312312312");
        usuario1.setNome("Jose");
        usuario1.setSenha("12345678");
        usuario1.setLogin("TheF");

        Usuario usuario2 = new Usuario();
        usuario1.setCpf("88888312312");
        usuario1.setNome("Joao");
        usuario1.setSenha("87654321");
        usuario1.setLogin("Goru");

        entityManager.persist(usuario1);
        entityManager.persist(usuario2);

        var usuarios = usuarioRepository.findAll();

        Assertions.assertEquals(List.of(usuario1, usuario2), usuarios);
    }
}

