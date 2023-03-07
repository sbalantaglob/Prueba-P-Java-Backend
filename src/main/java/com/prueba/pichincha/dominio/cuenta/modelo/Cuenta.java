package com.prueba.pichincha.dominio.cuenta.modelo;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {

    private Long id;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Integer saldoInicial;
    private Boolean estado;
    private Cliente cliente;

    public Cuenta(Long numeroCuenta, String tipoCuenta, Integer saldoInicial, Boolean estado, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.cliente = cliente;
    }

}
