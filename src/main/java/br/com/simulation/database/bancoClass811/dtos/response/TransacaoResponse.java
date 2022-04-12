package br.com.simulation.database.bancoClass811.dtos.response;

import br.com.simulation.database.bancoClass811.models.Conta;
import br.com.simulation.database.bancoClass811.models.TipoTransacao;
import br.com.simulation.database.bancoClass811.models.Transacao;

import java.math.BigDecimal;

public class TransacaoResponse {
    private BigDecimal valor;
    private TipoTransacao tipoTransacao;

    public TransacaoResponse(Transacao transacao){
        this.valor = transacao.getValor();
        this.tipoTransacao = transacao.getTipoTransacao();
    }
}
