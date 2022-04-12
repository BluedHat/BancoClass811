package br.com.simulation.database.bancoClass811.services;

import br.com.simulation.database.bancoClass811.dtos.request.ContaRequest;
import br.com.simulation.database.bancoClass811.dtos.response.ContaResponse;
import br.com.simulation.database.bancoClass811.models.Conta;
import br.com.simulation.database.bancoClass811.models.Usuario;
import br.com.simulation.database.bancoClass811.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service

public class ContaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    UsuarioService usuarioService;

    public Conta insertNewConta (ContaRequest contaRequest, UUID id){

        Usuario user = usuarioService.getById(id);
        Conta conta = new Conta(contaRequest);
        conta.setUsuario(user);
        conta.setSaldo(contaRequest.getDepositoInicial());
        conta.setDataAtualizacao(LocalDateTime.now());
        conta.setDataCriacao(LocalDateTime.now());
        contaRepository.save(conta);

        return conta;
    }

    public Conta updateConta (ContaRequest contaRequest, UUID id){

        Usuario user = usuarioService.getById(id);
        Conta conta = new Conta(contaRequest);
        conta.setUsuario(user);
        conta.setDataAtualizacao(LocalDateTime.now());
        contaRepository.save(conta);

        return conta;
    }
    public void encerraConta(UUID ContaId){
        Conta conta = contaRepository.getById(ContaId);
        contaRepository.delete(conta);
    }
     public ContaResponse getContaById(UUID id){
        Conta conta = contaRepository.findById(id).orElseThrow();
        return new ContaResponse(conta);
    }
    public List<Conta> listaContas() {
        return new ArrayList<>(contaRepository.findAll());
    }
    public Conta getById(UUID id) {
        return contaRepository.findById(id).orElseThrow();
    }

    }
