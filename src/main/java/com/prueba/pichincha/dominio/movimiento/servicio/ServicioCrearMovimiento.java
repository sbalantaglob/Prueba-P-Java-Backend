package com.prueba.pichincha.dominio.movimiento.servicio;

import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import com.prueba.pichincha.dominio.utils.UtilsDominio;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ServicioCrearMovimiento {

    private final IRepositorioMovimiento iRepositorioMovimiento;

    public ServicioCrearMovimiento(IRepositorioMovimiento iRepositorioMovimiento) {
        this.iRepositorioMovimiento = iRepositorioMovimiento;
    }

    public Long ejecutar(Movimiento movimiento) {
        this.transformacionValorPorTipoTransaccion(movimiento);
        return this.iRepositorioMovimiento.guardar(movimiento);
    }

    public static Movimiento transformacionValorPorTipoTransaccion(Movimiento movimiento) {
        if (Objects.nonNull(movimiento.getTipoMovimiento())
                && movimiento.getTipoMovimiento().equals(UtilsDominio.DEBITO)) {
            UtilsDominio.validarSaldoDebito(movimiento.getSaldo());

            Integer negativeValue = movimiento.getValor() * -1;
            movimiento.setValor(negativeValue);
        }
        return movimiento;
    }
}
