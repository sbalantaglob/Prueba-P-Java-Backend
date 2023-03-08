package com.prueba.pichincha.aplicacion.fabrica;

import com.prueba.pichincha.aplicacion.dto.DtoCliente;
import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public Cliente crearCliente(DtoCliente dtoCliente) {
        return new Cliente(dtoCliente.getIdentificacion(), dtoCliente.getNombre(), dtoCliente.getGenero(),
                dtoCliente.getEdad(), dtoCliente.getDireccion(), dtoCliente.getTelefono(),
                 dtoCliente.getContrasena(), dtoCliente.getEstado());
    }

    public Cliente actualizarCliente(DtoCliente dtoCliente) {
        return new Cliente(dtoCliente.getId(), dtoCliente.getIdentificacion(), dtoCliente.getNombre(), dtoCliente.getGenero(),
                dtoCliente.getEdad(), dtoCliente.getDireccion(), dtoCliente.getTelefono(),
                dtoCliente.getContrasena(), dtoCliente.getEstado());
    }

}
