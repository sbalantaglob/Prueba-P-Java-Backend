package com.prueba.pichincha.dominio.cuenta.servicio;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.puerto.repositorio.IRepositorioCuenta;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarCuenta {

    private final IRepositorioCuenta iRepositorioCuenta;

    public ServicioActualizarCuenta(IRepositorioCuenta iRepositorioCuenta) {
        this.iRepositorioCuenta = iRepositorioCuenta;
    }

    public void ejecutar(Cuenta cuenta) {
        this.iRepositorioCuenta.actualizar(cuenta);
    }
}
