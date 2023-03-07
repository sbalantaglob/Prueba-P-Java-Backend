package com.prueba.pichincha.infraestructura.persistencia.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cuenta")
public class CuentaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long numeroCuenta;
    @Column(nullable = false, length = 20)
    private String tipoCuenta;
    @Column(nullable = false)
    private Integer saldoInicial;
    @Column(nullable = false)
    private Boolean estado;
    @OneToOne
    private ClienteEntidad clienteEntidad;

}
