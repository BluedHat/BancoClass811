package br.com.simulation.database.bancoClass811.dtos.request;

import br.com.simulation.database.bancoClass811.models.TipoConta;
import lombok.Getter;
import java.math.BigDecimal;

@Getter

public class ContaRequest {
    private TipoConta tipoConta;
    private Integer numero;
    private Integer digitoNumero;
    private Integer agencia;
    private Integer digitoAgencia;
    private BigDecimal depositoInicial;

}
