package com.prueba.pichincha.infraestructura.persistencia.repositorio;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cliente.puerto.repositorio.IRepositorioCliente;
import com.prueba.pichincha.dominio.excepcion.ExcepcionSinDatos;
import com.prueba.pichincha.dominio.excepcion.ExcepcionYaExiste;
import com.prueba.pichincha.infraestructura.persistencia.builder.ClienteBuilder;
import com.prueba.pichincha.infraestructura.persistencia.entidad.ClienteEntidad;
import com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa.IRepositorioClienteJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioCliente implements IRepositorioCliente {

    private static final String MENSAJE_CREAR_YA_EXISTE = "Ya existe esta identificacion en el sistema, por favor cambiela.";
    private static final String MENSAJE_ACTUALIZAR_NO_EXISTE = "No se puedo actualizar cliente, porque no existe.";
    private static final String MENSAJE_ELIMINAR_NO_EXISTE = "No se puedo eliminar cliente, no existe.";
    private static final String MENSAJE_NO_EXISTE_CLIENTE = "No existe ningun cliente con esta identificacion.";

    private IRepositorioClienteJPA repositorioClienteJPA;

    public RepositorioCliente(IRepositorioClienteJPA repositorioClienteJPA) {
        this.repositorioClienteJPA = repositorioClienteJPA;
    }

    @Override
    public Long guardar(Cliente cliente) {

        if ( this.existePorIdentificacion(cliente.getIdentificacion()) ) {
             throw new ExcepcionYaExiste(MENSAJE_CREAR_YA_EXISTE);
        }
        ClienteEntidad clienteEntidad = ClienteBuilder.convertirAEntidad(cliente);
        clienteEntidad = repositorioClienteJPA.save(clienteEntidad);
        return clienteEntidad.getId();
    }

    @Override
    public Cliente obtenerPorIdentificacion(Long identificacion) {
        Optional<ClienteEntidad> clienteEntidad = repositorioClienteJPA.encontrarPorIdentificacion(identificacion);
        return ClienteBuilder.convertirADominio(clienteEntidad.orElseThrow(() ->
                new ExcepcionSinDatos(MENSAJE_NO_EXISTE_CLIENTE)));
    }

    @Override
    public Boolean existePorIdentificacion(Integer identificacion) {
        return repositorioClienteJPA.existePorIdentificacion(identificacion);
    }

    @Override
    public Boolean existeClientePorIdYIdentificacion(Long id, Integer identificacion) {
        return repositorioClienteJPA.existePorIdYIdentificacion(id, identificacion);
    }

    @Override
    public void actualizar(Cliente cliente) {
        if (this.existeClientePorIdYIdentificacion(cliente.getId(), cliente.getIdentificacion())) {
            ClienteEntidad clienteEntidad = ClienteBuilder.convertirAEntidad(cliente);
            repositorioClienteJPA.save(clienteEntidad);
        } else {
            throw new ExcepcionSinDatos(MENSAJE_ACTUALIZAR_NO_EXISTE);
        }
    }

    @Override
    public void eliminar(Long id) {
        Optional<ClienteEntidad> clienteEntidad = repositorioClienteJPA.encontrarPorIdentificacion(id);
        repositorioClienteJPA.delete(clienteEntidad.orElseThrow(() ->
                new ExcepcionSinDatos(MENSAJE_ELIMINAR_NO_EXISTE)));
    }
}
