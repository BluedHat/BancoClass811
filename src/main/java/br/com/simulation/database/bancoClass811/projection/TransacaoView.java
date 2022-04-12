package br.com.simulation.database.bancoClass811.projection;

import br.com.simulation.database.bancoClass811.models.TipoTransacao;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransacaoView {
    LocalDateTime getDataTransacao();
    TipoTransacao getTipoTransacao();
    BigDecimal getValor();
}
