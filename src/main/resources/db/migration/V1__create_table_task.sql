CREATE TABLE task (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(2000),
    pstatus VARCHAR(50) NOT NULL,
    prioridade VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    data_criacao DATETIME NOT NULL,
    data_conclusao DATETIME,

    PRIMARY KEY (id)
);
