package com.TaskManager.TaskManager.Model.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Prioridade {

    BAIXA("Baixa Prioridade"),
    MEDIA("Média Prioridade"),
    ALTA("Alta Prioridade"),
    MAXIMA("Prioridade Maxima");

        private final String descricao;

    Prioridade(String descricao){
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return this.descricao;
    }

    @JsonValue
    public Prioridade fromValue(String value){
        for(Prioridade prioridade : values()){
            if(prioridade.descricao.equalsIgnoreCase(value)) return prioridade;
        }
        throw new RuntimeException("Erro Prioridade errada: "+value);
    }
}
