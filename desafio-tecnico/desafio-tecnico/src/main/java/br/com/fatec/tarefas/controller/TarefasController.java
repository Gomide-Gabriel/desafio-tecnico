package br.com.fatec.tarefas.controller;


import br.com.fatec.tarefas.model.Tarefas;
import br.com.fatec.tarefas.service.TarefasService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }


    // GET - LISTANDO TUDO
    @GetMapping
    public ResponseEntity<List<Tarefas>> listar(){
        return ResponseEntity.ok(tarefasService.listarTarefas());
    }

    // GET - LISTANDO POR INDEX
    @GetMapping("/{index}")
    public ResponseEntity<Tarefas> listaPorIndex(@PathVariable int index){
        Tarefas novaTarefa = tarefasService.listarPorIndice(index);
        if (novaTarefa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(novaTarefa);
    }

    // POST
    @PostMapping
    public ResponseEntity<Tarefas> adicionar(@RequestBody Tarefas tarefa){
        Tarefas novaTarefa = tarefasService.adicionar(tarefa);
        return ResponseEntity.status(201).body(novaTarefa);
    }

    // PUT
    @PutMapping("/{index}")
    public ResponseEntity<Tarefas> atualizar(@PathVariable int index, @RequestBody Tarefas tarefa){
        Tarefas novaTarefa = tarefasService.atualizar(index, tarefa);
        if (novaTarefa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(novaTarefa);
    }

    // DELETE
    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deletar(@PathVariable int index){
        boolean tarefaDeletada = tarefasService.deletar(index);
        if(!tarefaDeletada)
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}
