package com.prueba.pichincha.infraestructura.persistencia.entidad;

import jakarta.persistence.*;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@MappedSuperclass
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class PersonaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Integer identificacion;
    @Column(nullable = false)
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
