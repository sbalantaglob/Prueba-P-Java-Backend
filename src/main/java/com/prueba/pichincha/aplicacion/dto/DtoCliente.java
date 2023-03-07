package com.prueba.pichincha.aplicacion.dto;

import com.prueba.pichincha.dominio.cliente.modelo.Persona;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DtoCliente extends Persona {

    private Long id;
    private String contrasena;
    private Boolean estado;

    public DtoCliente(Long id, Integer idenfiticacion, String nombre, String genero, Integer edad, String direccion, String telefono,
                       String contrasena, Boolean estado) {
        super(idenfiticacion, nombre, genero, edad, direccion, telefono);
        this.id = id;
        this.contrasena = contrasena;
        this.estado = estado;
    }

}
