package com.prueba.pichincha.infraestructura.persistencia.repositorio;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cliente.puerto.repositorio.IRepositorioCliente;
import com.prueba.pichincha.dominio.excepcion.ExcepcionSinDatos;
import com.prueba.pichincha.infraestructura.persistencia.builder.ClienteBuilder;
import com.prueba.pichincha.infraestructura.persistencia.entidad.ClienteEntidad;
import com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa.IRepositorioClienteJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioCliente implements IRepositorioCliente {
    private static final String MENSAJE_ELIMINAR_NO_EXISTE = "No se puedo eliminar cliente, no existe.";

    private IRepositorioClienteJPA repositorioClienteJPA;

    public RepositorioCliente(IRepositorioClienteJPA repositorioClienteJPA) {
        this.repositorioClienteJPA = repositorioClienteJPA;
    }

    @Override
    public Long guardar(Cliente cliente) {
        ClienteEntidad clienteEntidad = ClienteBuilder.convertirAEntidad(cliente);
        clienteEntidad = repositorioClienteJPA.save(clienteEntidad);
        return clienteEntidad.getId();
    }

    @Override
    public Cliente obtenerPorIdentificacion(Long identificacion) {
       /* ClienteEntidad clienteEntidad = repositorioClienteJPA.findByIdenfiticacion(identificacion);
        return ClienteBuilder.convertirADominio(clienteEntidad);*/
        return new Cliente();
    }

    @Override
    public void actualizar(Cliente cliente) {
        ClienteEntidad clienteEntidad = ClienteBuilder.convertirAEntidad(cliente);
        repositorioClienteJPA.save(clienteEntidad);
    }

    @Override
    public void eliminar(Long id) {
        Optional<ClienteEntidad> clienteEntidad = repositorioClienteJPA.findById(id);
        repositorioClienteJPA.delete(clienteEntidad.orElseThrow(() ->
                new ExcepcionSinDatos(MENSAJE_ELIMINAR_NO_EXISTE)));
    }
}
