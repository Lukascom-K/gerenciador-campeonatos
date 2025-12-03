package com.gerenciadorcampeonatos.service;

public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(String msg) {
        super(msg);
    }
}
