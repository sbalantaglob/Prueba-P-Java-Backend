package com.prueba.pichincha.dominio.cliente.servicio;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cliente.puerto.repositorio.IRepositorioCliente;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarCliente {

    private final IRepositorioCliente iRepositorioCliente;

    public ServicioActualizarCliente(IRepositorioCliente iRepositorioCliente) {
        this.iRepositorioCliente = iRepositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        this.iRepositorioCliente.actualizar(cliente);
    }
}
