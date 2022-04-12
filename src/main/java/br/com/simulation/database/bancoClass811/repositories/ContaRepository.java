package br.com.simulation.database.bancoClass811.repositories;

import br.com.simulation.database.bancoClass811.models.Conta;
import br.com.simulation.database.bancoClass811.models.TipoConta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository

public interface ContaRepository extends JpaRepository<Conta, UUID> {

    List<Conta> findByNumero(int numero);
    List<Conta> findByTipoConta(TipoConta tipoConta);
    Page<Conta> findByAgencia(int agencia,  Pageable pageable);

}
