package com.prueba.pichincha.dominio.cliente.puerto.repositorio;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;

public interface IRepositorioCliente {

    Long guardar(Cliente cliente);

    Cliente obtenerPorIdentificacion(Long identificacion);

    void actualizar(Cliente cliente);

    void eliminar(Long id);

}
