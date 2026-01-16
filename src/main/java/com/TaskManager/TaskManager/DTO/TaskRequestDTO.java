package com.TaskManager.TaskManager.DTO;

import com.TaskManager.TaskManager.Model.Enum.Prioridade;

import java.io.Serializable;

public class TaskRequestDTO  implements Serializable {

    private static final long serialVersionUID = 1L;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(String titulo, String descricao, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }


}
