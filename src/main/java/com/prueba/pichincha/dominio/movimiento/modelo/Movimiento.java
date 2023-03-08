package com.prueba.pichincha.dominio.movimiento.modelo;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.excepcion.ValidadorArgumento;
import com.prueba.pichincha.infraestructura.persistencia.entidad.CuentaEntidad;
import jakarta.persistence.OneToOne;
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
    private CuentaEntidad cuentaEntidad;

    public Movimiento(String tipoMovimiento, Integer valor, Integer saldo, Timestamp fecha) {
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.fecha = fecha;
    }

    public static Movimiento reconstruir(Long id, String tipoMovimiento, Integer valor, Integer saldo,
                                     Timestamp fecha, CuentaEntidad cuentaEntidad) {
        ValidadorArgumento.validarObligatorio(id, "El id del movimiento es obligatorio.");
        ValidadorArgumento.validarObligatorio(tipoMovimiento, "El tipo de movimiento es obligatorio.");
        ValidadorArgumento.validarObligatorio(valor, "El valor en el movimiento es obligatorio.");
        ValidadorArgumento.validarObligatorio(saldo, "El saldo en el movimiento es obligatorio.");
        ValidadorArgumento.validarObligatorio(fecha, "La fecha del movimiento es obligatoria.");
        ValidadorArgumento.validarObligatorio(cuentaEntidad, "La cuenta del movimiento es obligatoria.");
        return new Movimiento(id, tipoMovimiento, valor, saldo,fecha, cuentaEntidad);
    }


}
