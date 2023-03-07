package com.prueba.pichincha.dominio.cliente.servicio;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cliente.puerto.repositorio.IRepositorioCliente;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ServicioObtenerCliente {

    private final IRepositorioCliente iRepositorioCliente;

    public ServicioObtenerCliente(IRepositorioCliente iRepositorioCliente) {
        this.iRepositorioCliente = iRepositorioCliente;
    }

    public Cliente ejecutar(Long identificacion) {
        return this.iRepositorioCliente.obtenerPorIdentificacion(identificacion);
    }

}
