package com.prueba.pichincha.dominio.excepcion;

public class ExcepcionYaExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionYaExiste(String message) {
        super(message);
    }
}
