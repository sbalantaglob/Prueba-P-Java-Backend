package com.prueba.pichincha.dominio.movimiento.servicio;

import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import org.springframework.stereotype.Component;

@Component
public class ServicioActualizarMovimiento {

    private final IRepositorioMovimiento iRepositorioMovimiento;

    public ServicioActualizarMovimiento(IRepositorioMovimiento iRepositorioMovimiento) {
        this.iRepositorioMovimiento = iRepositorioMovimiento;
    }

    public void ejecutar(Movimiento movimiento) {
        this.iRepositorioMovimiento.actualizar(movimiento);
    }
}
