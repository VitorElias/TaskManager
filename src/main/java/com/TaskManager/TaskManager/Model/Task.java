package com.TaskManager.TaskManager.Model;

import com.TaskManager.TaskManager.Model.Enum.Prioridade;
import com.TaskManager.TaskManager.Model.Enum.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "titulo", nullable = false )
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "pstatus" , nullable = false)
    @Enumerated(EnumType.STRING)
    private Status ptatus;

    @Column(name = "prioridade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "dataCriacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "dataConclusao", nullable = false)
    private LocalDateTime dataConclusao;


    public Task() {
    }

    public Task(Long id, String titulo, String descricao, Status ptatus, Prioridade prioridade, LocalDateTime dataConclusao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ptatus = ptatus;
        this.prioridade = prioridade;
        this.ativo = true;
        this.dataCriacao = LocalDateTime.now();
        this.dataConclusao = dataConclusao;
    }

    public Task(String titulo, String descricao, Status ptatus, Prioridade prioridade, LocalDateTime dataConclusao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.ptatus = ptatus;
        this.prioridade = prioridade;
        this.ativo = true;
        this.dataCriacao = LocalDateTime.now();
        this.dataConclusao = dataConclusao;
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

    public Status getPtatus() {
        return ptatus;
    }

    public void setPtatus(Status ptatus) {
        this.ptatus = ptatus;
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

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", ptatus=" + ptatus +
                ", prioridade=" + prioridade +
                ", ativo=" + ativo +
                ", dataCriacao=" + dataCriacao +
                ", dataConclusao=" + dataConclusao +
                '}';
    }
    
}
