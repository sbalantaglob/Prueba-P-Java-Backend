package com.prueba.pichincha.dominio.movimiento.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {

    private Long id;
    private String tipoMovimiento;
    private Integer valor;
    private Integer saldo;
    private Timestamp fecha;

    public Movimiento(String tipoMovimiento, Integer valor, Integer saldo, Timestamp fecha) {
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.fecha = fecha;
    }


}
