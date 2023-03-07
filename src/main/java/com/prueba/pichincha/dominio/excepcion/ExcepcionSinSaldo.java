package com.prueba.pichincha.dominio.excepcion;

public class ExcepcionSinSaldo extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionSinSaldo(String message) {
        super(message);
    }
}
