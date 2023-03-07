package com.prueba.pichincha.dominio.movimiento.puerto.repositorio;

import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;

import java.sql.Timestamp;

public interface IRepositorioMovimiento {

    Long guardar(Movimiento movimiento);

    Movimiento obtenerPorCliente(Long identificacion);

    void actualizar(Movimiento cliente);

    void eliminar(Long id);

}
