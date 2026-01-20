package com.TaskManager.TaskManager.DTO;

import com.TaskManager.TaskManager.Model.Enum.Prioridade;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonPropertyOrder({"titulo","prioridade","descricao","data_Conclusao"})
public class TaskRequestDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "titulo")
    private String titulo;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "prioridade")
    private Prioridade prioridade;

    @JsonProperty(value = "data_Conclusao")
    @JsonFormat(pattern = "yyyy-MM-dd HH")
    private LocalDateTime dataConclusao;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(String titulo, String descricao, Prioridade prioridade, LocalDateTime dataConclusao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.dataConclusao = dataConclusao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
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
