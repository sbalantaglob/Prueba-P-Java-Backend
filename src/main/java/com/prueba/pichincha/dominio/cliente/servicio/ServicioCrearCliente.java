package com.prueba.pichincha.dominio.cliente.servicio;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cliente.puerto.repositorio.IRepositorioCliente;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearCliente {

    private final IRepositorioCliente iRepositorioCliente;

    public ServicioCrearCliente(IRepositorioCliente iRepositorioCliente) {
        this.iRepositorioCliente = iRepositorioCliente;
    }

    public Long ejecutar(Cliente cliente) {
        return this.iRepositorioCliente.guardar(cliente);
    }
}
