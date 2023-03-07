package com.prueba.pichincha.dominio.cuenta.servicio;

import com.prueba.pichincha.dominio.cuenta.puerto.repositorio.IRepositorioCuenta;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarCuenta {

    private final IRepositorioCuenta iRepositorioCuenta;

    public ServicioEliminarCuenta(IRepositorioCuenta iRepositorioCuenta) {
        this.iRepositorioCuenta = iRepositorioCuenta;
    }

    public void ejecutar(Long id) {
        this.iRepositorioCuenta.eliminar(id);
    }

}
