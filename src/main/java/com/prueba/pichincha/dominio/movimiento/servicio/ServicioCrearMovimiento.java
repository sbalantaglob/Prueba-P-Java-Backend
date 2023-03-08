package com.prueba.pichincha.dominio.movimiento.servicio;

import com.prueba.pichincha.dominio.excepcion.ExcepcionSinSaldo;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ServicioCrearMovimiento {

    public static final String DEBITO = "Debito";
    public static final String CREDITO = "Credito";
    public static final String SIN_SALDO = "No puede realizar un movimiento de debito sin saldo.";

    private final IRepositorioMovimiento iRepositorioMovimiento;

    public ServicioCrearMovimiento(IRepositorioMovimiento iRepositorioMovimiento) {
        this.iRepositorioMovimiento = iRepositorioMovimiento;
    }

    public Long ejecutar(Movimiento movimiento) {
        this.transformacionValorPorTipoTransaccion(movimiento);
        return this.iRepositorioMovimiento.guardar(movimiento);
    }

    public Movimiento transformacionValorPorTipoTransaccion(Movimiento movimiento) {
        if (Objects.nonNull(movimiento.getTipoMovimiento())
                && movimiento.getTipoMovimiento().equals(DEBITO)) {
            this.validarSaldoDebito(movimiento.getSaldo());

            Integer negativeValue = movimiento.getSaldo() * -1;
            movimiento.setValor(negativeValue);
        }
        return movimiento;
    }

    public void validarSaldoDebito(Integer saldo) {
        if (saldo.equals(0)) {
            throw new ExcepcionSinSaldo(SIN_SALDO);
        }
    }
}
