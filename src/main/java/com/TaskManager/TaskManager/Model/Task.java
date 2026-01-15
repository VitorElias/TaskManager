package com.TaskManager.TaskManager.Model;

import java.io.Serializable;

public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String titulo;

    private String descricao;

    private Enum Status;


}
