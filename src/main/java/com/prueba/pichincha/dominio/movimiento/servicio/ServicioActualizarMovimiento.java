package com.prueba.pichincha.dominio.movimiento.servicio;

import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import com.prueba.pichincha.dominio.utils.UtilsDominio;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ServicioActualizarMovimiento {

    private final IRepositorioMovimiento iRepositorioMovimiento;

    public ServicioActualizarMovimiento(IRepositorioMovimiento iRepositorioMovimiento) {
        this.iRepositorioMovimiento = iRepositorioMovimiento;
    }

    public void ejecutar(Movimiento movimiento) {
        this.transformacionValorPorTipoTransaccion(movimiento);
        this.iRepositorioMovimiento.actualizar(movimiento);
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
