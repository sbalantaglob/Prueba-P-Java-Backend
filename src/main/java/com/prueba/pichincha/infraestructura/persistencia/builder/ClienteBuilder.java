package com.prueba.pichincha.infraestructura.persistencia.builder;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.infraestructura.persistencia.entidad.ClienteEntidad;

import java.util.Objects;

public final class ClienteBuilder {
    
    private ClienteBuilder() {
    }
    
    public static Cliente convertirADominio(ClienteEntidad clienteEntidad) {
        Cliente cliente = new Cliente();
        if (Objects.nonNull(clienteEntidad) ) {
            cliente = new Cliente(clienteEntidad.getId(), clienteEntidad.getIdenfiticacion(),
                    clienteEntidad.getNombre(), clienteEntidad.getGenero(),
                    clienteEntidad.getEdad(), clienteEntidad.getDireccion(),
                    clienteEntidad.getTelefono(), clienteEntidad.getContrasena(),
                    clienteEntidad.getEstado());
        }
        return cliente;
    }

    public static ClienteEntidad convertirAEntidad(Cliente cliente) {
        ClienteEntidad clienteEntidad = new ClienteEntidad();
        clienteEntidad.setId(Objects.nonNull(cliente.getId()) ? cliente.getId() : null);
        clienteEntidad.setIdenfiticacion(cliente.getIdenfiticacion());
        clienteEntidad.setNombre(cliente.getNombre());
        clienteEntidad.setGenero(cliente.getGenero());
        clienteEntidad.setEdad(cliente.getEdad());
        clienteEntidad.setDireccion(cliente.getDireccion());
        clienteEntidad.setTelefono(cliente.getTelefono());
        clienteEntidad.setContrasena(cliente.getContrasena());
        clienteEntidad.setEstado(cliente.getEstado());
        return clienteEntidad;
    }
    
}
