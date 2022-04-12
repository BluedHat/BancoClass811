package br.com.simulation.database.bancoClass811.controllers;

import br.com.simulation.database.bancoClass811.dtos.request.TransacaoRequest;
import br.com.simulation.database.bancoClass811.models.TipoTransacao;
import br.com.simulation.database.bancoClass811.models.Transacao;
import br.com.simulation.database.bancoClass811.projection.TransacaoView;
import br.com.simulation.database.bancoClass811.repositories.TransacaoRepository;
import br.com.simulation.database.bancoClass811.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transacao")

public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @Autowired
    TransacaoRepository transacaoRepository;

    //realizar transacoes
    @PostMapping("made/{id}")
    public ResponseEntity<Object> makeNewTransacao(@PathVariable(value = "id") UUID id,
                                                   @RequestBody
                                                   @Valid TransacaoRequest transacaoRequest){
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.transacao(transacaoRequest,id));
    }

    /* lista trasacoes por data modo all data */
    @GetMapping("/data")
    public ResponseEntity<List<Transacao>> listByData(){
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.getByDataTransacao());
    }

    /* lista trasacoes por conta - modo all data */
    @GetMapping("/conta")
    public ResponseEntity<List<Transacao>> listByConta(){
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.getByContaTransacao());
    }

    /* lista as transacoes por pagina em ordem de ID */
    @GetMapping("/listpage")
    public Page<Transacao> byPage(){
        return transacaoRepository.findAll(PageRequest.of(0,1,
                                           Sort.by(
                                           Sort.Direction.ASC,"id")));
    }

    @GetMapping("/view")
    public List<TransacaoView> listByTipo(
            @RequestParam TipoTransacao tipoTransacao) {
        return transacaoService.listAllByType(tipoTransacao);
    }
}


