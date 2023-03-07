package com.prueba.pichincha.dominio.cliente.servicio;

import com.prueba.pichincha.dominio.cliente.puerto.repositorio.IRepositorioCliente;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarCliente {

    private final IRepositorioCliente iRepositorioCliente;

    public ServicioEliminarCliente(IRepositorioCliente iRepositorioCliente) {
        this.iRepositorioCliente = iRepositorioCliente;
    }

    public void ejecutar(Long id) {
        this.iRepositorioCliente.eliminar(id);
    }

}
