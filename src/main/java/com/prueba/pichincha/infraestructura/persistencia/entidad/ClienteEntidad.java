package com.prueba.pichincha.infraestructura.persistencia.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntidad extends PersonaEntidad {

    @Column(nullable = false, length = 50)
    private String contrasena;
    @Column(nullable = false)
    private Boolean estado;

    public ClienteEntidad(Integer identificacion, String nombre, String genero, Integer edad, String direccion, String telefono,
                          Long id, String contrasena, Boolean estado) {
        super(id, identificacion, nombre, genero, edad, direccion, telefono);
        this.contrasena = contrasena;
        this.estado = estado;
    }

}
