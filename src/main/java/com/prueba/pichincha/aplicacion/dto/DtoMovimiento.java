package com.prueba.pichincha.aplicacion.dto;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DtoMovimiento {

    private Long id;
    private String tipoMovimiento;
    private Integer valor;
    private Integer saldo;
    private Timestamp fecha;
    private Cuenta cuenta;

}
