package br.com.simulation.database.bancoClass811.services;

import br.com.simulation.database.bancoClass811.dtos.request.TransacaoRequest;
import br.com.simulation.database.bancoClass811.models.Conta;
import br.com.simulation.database.bancoClass811.models.TipoTransacao;
import br.com.simulation.database.bancoClass811.models.Transacao;
import br.com.simulation.database.bancoClass811.projection.TransacaoView;
import br.com.simulation.database.bancoClass811.repositories.ContaRepository;
import br.com.simulation.database.bancoClass811.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service

public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    ContaService contaService;

    public String transacao(TransacaoRequest transacaoRequest, UUID id){
           Conta conta = contaService.getById(id);
           Transacao transacao = new Transacao();
           transacao.setTipoTransacao(transacaoRequest.getTipoTransacao());
           transacao.setValor(transacaoRequest.getValor());
           transacao.setDataTransacao(LocalDateTime.now());
           transacao.setConta(conta);

           String movimentacao = String.valueOf(transacao.getTipoTransacao());
           BigDecimal saldoAtual = conta.getSaldo();

           if(movimentacao.equals("credito")){
               conta.setSaldo(saldoAtual.subtract(transacao.getValor()));
               contaRepository.save(conta);
               transacaoRepository.save(transacao);
               return "valor creditado com sucesso";
           }
           else if(movimentacao.equals("debito")){
               conta.setSaldo(saldoAtual.add(transacao.getValor()));
               contaRepository.save(conta);
               transacaoRepository.save(transacao);
               return "valor debitado com sucesso";
           }
           else{
            return "Transação não permitida, favor verificar os dados";
        }
    }

    public List<Transacao> getByDataTransacao() {
        return transacaoRepository.findAll(Sort
                                        .by(Sort
                                        .Direction
                                        .ASC,
                              "dataTransacao"));
    }


    public List<Transacao> getByContaTransacao() {
        return transacaoRepository.findAll(Sort
                                .by(Sort
                                .Direction
                                .ASC,
                        "conta"));
    }

    public List<TransacaoView> listAllByType(TipoTransacao tipoTransacao) {
        return transacaoRepository.findAllByTipoTransacao(tipoTransacao);
    }

}

