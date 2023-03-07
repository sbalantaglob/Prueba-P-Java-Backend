package com.prueba.pichincha.dominio.excepcion;

public class ExcepcionSinDatos extends RuntimeException {

    private static final long serialVersionUID = 1;

    public ExcepcionSinDatos(String message) {
        super(message);
    }
}
