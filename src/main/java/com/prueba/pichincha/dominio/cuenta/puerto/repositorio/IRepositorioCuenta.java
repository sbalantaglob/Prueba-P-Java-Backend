package com.prueba.pichincha.dominio.cuenta.puerto.repositorio;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;

public interface IRepositorioCuenta {

    Long guardar(Cuenta cuenta);

    Cuenta obtenerPorNumeroCuenta(Long identificacion);

    void actualizar(Cuenta cliente);

    void eliminar(Long id);

}
