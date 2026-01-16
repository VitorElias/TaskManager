package com.TaskManager.TaskManager.DTO;

import com.TaskManager.TaskManager.Model.Enum.Prioridade;
import com.TaskManager.TaskManager.Model.Enum.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonPropertyOrder({"ID","titulo","descricao","statusTarefa","prioridadeTarefa","ativo","dataCriacao","dataConclusao"})
public class TaskResponseDTO implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @JsonProperty(value = "ID")
    private Long id;

    @JsonProperty(value = "título")
    private String titulo;

    @JsonProperty(value = "descrição")
    private String descricao;

    @JsonProperty(value = "statusTarefa")
    private Status status;

    @JsonProperty(value = "prioridadeTarefa")
    private Prioridade prioridade;

    @JsonProperty(value = "ativo")
    private boolean ativo;

    @JsonProperty(value = "dataCriacao")
    private LocalDateTime dataCriacao;

    @JsonProperty(value = "dataConclusao")
    private LocalDateTime dataconclusao;

    public TaskResponseDTO(Long id, String titulo, String descricao, Status status, Prioridade prioridade, boolean ativo, LocalDateTime dataCriacao, LocalDateTime dataconclusao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
        this.dataconclusao = dataconclusao;
    }

    public TaskResponseDTO(String titulo, String descricao, Status status, Prioridade prioridade, boolean ativo, LocalDateTime dataCriacao, LocalDateTime dataconclusao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
        this.dataconclusao = dataconclusao;
    }

    public TaskResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(LocalDateTime dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TaskResponseDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "TaskResponseDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", prioridade=" + prioridade +
                ", ativo=" + ativo +
                ", dataCriacao=" + dataCriacao +
                ", dataconclusao=" + dataconclusao +
                '}';
    }
}
