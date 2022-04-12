package br.com.simulation.database.bancoClass811.models;

import br.com.simulation.database.bancoClass811.dtos.request.ContaRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "conta")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "digito_numero")
    private Integer digitoNumero;

    @Column(name = "agencia")
    private Integer agencia;

    @Column(name = "digito_agencia")
    private Integer digitoAgencia;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @Column(name = "deposito_inicial")
    private BigDecimal depositoInicial;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Conta(ContaRequest contaRequest) {
        this.tipoConta = contaRequest.getTipoConta();
        this.agencia = contaRequest.getAgencia();
        this.digitoAgencia = contaRequest.getDigitoAgencia();
        this.numero = contaRequest.getNumero();
        this.digitoNumero = contaRequest.getDigitoNumero();
        this.depositoInicial = contaRequest.getDepositoInicial();
    }
}
