package br.com.simulation.database.bancoClass811.dtos.request;

import br.com.simulation.database.bancoClass811.models.TipoTransacao;
import java.math.BigDecimal;
import lombok.Getter;

@Getter

public class TransacaoRequest {
    private BigDecimal valor;
    private TipoTransacao tipoTransacao;
}
