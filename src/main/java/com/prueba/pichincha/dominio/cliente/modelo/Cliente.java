package com.prueba.pichincha.dominio.cliente.modelo;

import com.prueba.pichincha.dominio.cliente.modelo.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Persona {

    private Long id;
    private String contrasena;
    private Boolean estado;

    public Cliente(Long id, Integer idenfiticacion, String nombre, String genero, Integer edad, String direccion, String telefono,
                    String contrasena, Boolean estado) {
        super(idenfiticacion, nombre, genero, edad, direccion, telefono);
        this.id = id;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Cliente(Integer idenfiticacion, String nombre, String genero, Integer edad, String direccion, String telefono,
                   String contrasena, Boolean estado) {
        super(idenfiticacion, nombre, genero, edad, direccion, telefono);
        this.contrasena = contrasena;
        this.estado = estado;
    }

}
