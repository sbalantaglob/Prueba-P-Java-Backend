package com.prueba.pichincha.dominio.movimiento.servicio;

import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import org.springframework.stereotype.Component;

@Component
public class ServicioEliminarMovimiento {

    private final IRepositorioMovimiento iRepositorioMovimiento;

    public ServicioEliminarMovimiento(IRepositorioMovimiento iRepositorioMovimiento) {
        this.iRepositorioMovimiento = iRepositorioMovimiento;
    }

    public void ejecutar(Long id) {
        this.iRepositorioMovimiento.eliminar(id);
    }

}
