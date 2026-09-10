package br.com.fatec.tarefas.service;

import br.com.fatec.tarefas.model.Tarefas;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefasService {

    private final ArrayList<Tarefas> listaTarefas = new ArrayList<>();

    // Lista Tarefas
    public List<Tarefas> listarTarefas(){
        return listaTarefas;
    }

    // buscar específico
    public Tarefas listarPorIndice(int index){
        if (index < 0 || index >= listaTarefas.size())
            return null;
        return listaTarefas.get(index);
    }

    // adicionar tarefa
    public Tarefas adicionar(Tarefas tarefa){

        listaTarefas.add(tarefa);
        return tarefa;
    }

    // atualizar tarefa
    public Tarefas atualizar(int index, Tarefas tarefa){
        if (index < 0 || index >= listaTarefas.size())
            return null;

        listaTarefas.set(index, tarefa);
        return tarefa;
    }

    // deletar tarefa específíca
    public boolean deletar(int index){
        if (index < 0 || index >= listaTarefas.size())
            return false;

        listaTarefas.remove(index);
        return true;
    }

}
