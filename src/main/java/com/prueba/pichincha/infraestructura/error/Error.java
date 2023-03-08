package com.prueba.pichincha.infraestructura.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {

    private String excepcionNombre;
    private String mensaje;

}

