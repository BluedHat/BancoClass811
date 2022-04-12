package br.com.simulation.database.bancoClass811.repositories;

import br.com.simulation.database.bancoClass811.models.TipoTransacao;
import br.com.simulation.database.bancoClass811.models.Transacao;
import br.com.simulation.database.bancoClass811.projection.TransacaoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {

    /* 1.2.3 = db.tabela.coluna */

    @Query("select t from Transacao t where (t.tipoTransacao = :tipoTransacao)")
    List<TransacaoView> findAllByTipoTransacao(@Param("tipoTransacao")TipoTransacao tipoTransacao);
}
