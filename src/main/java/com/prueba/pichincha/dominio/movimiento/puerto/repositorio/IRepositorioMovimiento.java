package com.prueba.pichincha.dominio.movimiento.puerto.repositorio;

import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;

import java.sql.Timestamp;
import java.util.List;

public interface IRepositorioMovimiento {

    Long guardar(Movimiento movimiento);

    Movimiento obtenerPorId(Long id);

    List<Movimiento> obtenerPorFechasYCuenta(Timestamp fechaInicial, Timestamp fechaFinal, Long numeroCuenta);

    void actualizar(Movimiento cliente);

    void eliminar(Long id);

}
