package com.prueba.pichincha.dominio.cuenta.servicio;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.puerto.repositorio.IRepositorioCuenta;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearCuenta {

    private final IRepositorioCuenta iRepositorioCuenta;

    public ServicioCrearCuenta(IRepositorioCuenta iRepositorioCuenta) {
        this.iRepositorioCuenta = iRepositorioCuenta;
    }

    public Long ejecutar(Cuenta cuenta) {
        return this.iRepositorioCuenta.guardar(cuenta);
    }
}
