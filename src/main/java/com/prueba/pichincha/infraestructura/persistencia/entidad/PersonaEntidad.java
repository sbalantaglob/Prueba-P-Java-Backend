package com.prueba.pichincha.infraestructura.persistencia.entidad;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class PersonaEntidad {

    @Column(unique = true)
    private Integer idenfiticacion;
    @Column
    private String nombre;
    @Column
    private String genero;
    @Column
    private Integer edad;
    @Column
    private String direccion;
    @Column
    private String telefono;

}
