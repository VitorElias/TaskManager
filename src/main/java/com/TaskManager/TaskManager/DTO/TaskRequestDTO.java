package com.TaskManager.TaskManager.DTO;

import com.TaskManager.TaskManager.Model.Enum.Prioridade;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({"titulo","prioridade","descricao"})
public class TaskRequestDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "titulo")
    private String titulo;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "prioridade")
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
