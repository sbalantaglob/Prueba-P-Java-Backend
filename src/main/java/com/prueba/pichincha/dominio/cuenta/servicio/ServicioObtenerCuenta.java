package com.prueba.pichincha.dominio.cuenta.servicio;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.puerto.repositorio.IRepositorioCuenta;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ServicioObtenerCuenta {

    private final IRepositorioCuenta iRepositorioCuenta;

    public ServicioObtenerCuenta(IRepositorioCuenta iRepositorioCuenta) {
        this.iRepositorioCuenta = iRepositorioCuenta;
    }

    public Cuenta ejecutar(Long numeroCuenta) {
        return this.iRepositorioCuenta.obtenerPorNumeroCuenta(numeroCuenta);
    }

}
