package com.prueba.pichincha.dominio.movimiento.servicio;

import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ServicioObtenerMovimiento {

    private final IRepositorioMovimiento iRepositorioMovimiento;

    public ServicioObtenerMovimiento(IRepositorioMovimiento iRepositorioMovimiento) {
        this.iRepositorioMovimiento = iRepositorioMovimiento;
    }

    public Movimiento ejecutar(Long identificacion) {
        return this.iRepositorioMovimiento.obtenerPorCliente(identificacion);
    }

}
