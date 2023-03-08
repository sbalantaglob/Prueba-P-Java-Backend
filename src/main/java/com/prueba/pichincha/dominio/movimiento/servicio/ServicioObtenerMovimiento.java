package com.prueba.pichincha.dominio.movimiento.servicio;

import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class ServicioObtenerMovimiento {

    private final IRepositorioMovimiento iRepositorioMovimiento;

    public ServicioObtenerMovimiento(IRepositorioMovimiento iRepositorioMovimiento) {
        this.iRepositorioMovimiento = iRepositorioMovimiento;
    }

    public List<Movimiento> ejecutar(Timestamp fechaInicial, Timestamp fechaFinal, Long numeroCuenta) {
        return this.iRepositorioMovimiento.obtenerPorFechasYCuenta(fechaInicial, fechaFinal, numeroCuenta);
    }

}
