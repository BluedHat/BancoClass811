package br.com.simulation.database.bancoClass811.dtos.response;

import br.com.simulation.database.bancoClass811.models.Conta;
import br.com.simulation.database.bancoClass811.models.TipoConta;
import java.math.BigDecimal;

public class ContaResponse {
    private Integer numero;
    private Integer digitoNumero;
    private Integer agencia;
    private Integer digitoAgencia;
    private BigDecimal saldo;
    private TipoConta tipoConta;

    public ContaResponse (Conta conta){
        this.agencia = conta.getAgencia();
        this.digitoAgencia = conta.getDigitoAgencia();
        this.numero = conta.getNumero();
        this.digitoNumero = conta.getDigitoNumero();
        this.saldo = conta.getSaldo();
        this.tipoConta = conta.getTipoConta();
    }
}
