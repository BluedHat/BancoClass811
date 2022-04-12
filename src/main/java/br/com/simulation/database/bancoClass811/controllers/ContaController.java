package br.com.simulation.database.bancoClass811.controllers;

import br.com.simulation.database.bancoClass811.dtos.request.ContaRequest;
import br.com.simulation.database.bancoClass811.dtos.response.ContaResponse;
import br.com.simulation.database.bancoClass811.models.Conta;
import br.com.simulation.database.bancoClass811.models.TipoConta;
import br.com.simulation.database.bancoClass811.services.ContaService;
import br.com.simulation.database.bancoClass811.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/conta")

public class ContaController {

    @Autowired
    ContaService contaService;

    /* cria conta */
    @PostMapping("/create/{id}")
    public ResponseEntity<Object> addNewConta(@PathVariable(value = "id") UUID id,
                                              @RequestBody
                                              @Valid ContaRequest contaRequest){

    return ResponseEntity.status(HttpStatus.OK).body(contaService.insertNewConta(contaRequest,id));
    }

    /*atualiza uma conta a partir do ID */
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateConta(@PathVariable(value = "id") UUID id,
                                              @RequestBody
                                              @Valid ContaRequest contaRequest){

        return ResponseEntity.status(HttpStatus.OK).body(contaService.updateConta(contaRequest,id));
    }

    /* busca 1 id de conta */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getContaById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.getContaById(id));
    }

    /* lista contas sem ordenar */
    @GetMapping()
    public ResponseEntity <List<Conta>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.listaContas());
    }

    /* delete conta*/
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Object> encerraConta(@PathVariable(value = "id") UUID id) {
        contaService.encerraConta(id);
        return ResponseEntity.status(HttpStatus.OK).body("Conta encerrada");
    }

}
