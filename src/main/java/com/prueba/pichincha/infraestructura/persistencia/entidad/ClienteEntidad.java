package com.prueba.pichincha.infraestructura.persistencia.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cliente")
public class ClienteEntidad extends PersonaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String contrasena;
    @Column(nullable = false)
    private Boolean estado;

    public ClienteEntidad(Integer idenfiticacion, String nombre, String genero, Integer edad, String direccion, String telefono,
                          Long id, String contrasena, Boolean estado) {
        super(idenfiticacion, nombre, genero, edad, direccion, telefono);
        this.id = id;
        this.contrasena = contrasena;
        this.estado = estado;
    }

}
