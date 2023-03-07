package com.prueba.pichincha.dominio.cliente.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private Integer idenfiticacion;
    private String nombre;
    private String genero;
    private Integer edad;
    private String direccion;
    private String telefono;

}
