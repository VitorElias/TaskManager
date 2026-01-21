package com.TaskManager.TaskManager.Model.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em_Andamento"),
    ATRASADA("Atrasada"),
    CONCLUIDA("Concluida");

    private final String descricao;

    Status(String descricao){
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonValue
    public static Status fromValue(String value){
        for(Status status : values()){
            if(status.descricao.equalsIgnoreCase(value))return status;
        }

        throw new IllegalArgumentException("StatusInvalido: "+ value);
    }


}


