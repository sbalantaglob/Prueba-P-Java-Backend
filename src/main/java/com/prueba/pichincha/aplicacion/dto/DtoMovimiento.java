package com.prueba.pichincha.aplicacion.dto;

import lombok.*;

import java.math.BigDecimal;
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

}
