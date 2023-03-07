package com.prueba.pichincha.dominio.movimiento.servicio;

import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearMovimiento {

    private final IRepositorioMovimiento iRepositorioMovimiento;

    public ServicioCrearMovimiento(IRepositorioMovimiento iRepositorioMovimiento) {
        this.iRepositorioMovimiento = iRepositorioMovimiento;
    }

    public Long ejecutar(Movimiento movimiento) {
        return this.iRepositorioMovimiento.guardar(movimiento);
    }
}
