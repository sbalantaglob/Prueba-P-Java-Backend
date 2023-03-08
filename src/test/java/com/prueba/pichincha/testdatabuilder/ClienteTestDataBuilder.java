package com.prueba.pichincha.testdatabuilder;

import com.prueba.pichincha.aplicacion.dto.DtoCliente;
import com.prueba.pichincha.dominio.cliente.modelo.Cliente;

public class ClienteTestDataBuilder {

    private static final long ID = 10;
    private static final int IDENTIFICACION = 123456;
    private static final String NOMBRE = "Alejandro Perez";
    private static final String GENERO = "Masculino";
    private static final int EDAD = 35;
    private static final String DIRECCION = "Direccion Test 1";
    private static final String TELEFONO = "147852369";
    private static final String CONTRASENA = "123456789";
    private static final boolean ESTADO = true;

    private Long id;
    private Integer identificacion;
    private String nombre;
    private String genero;
    private Integer edad;
    private String direccion;
    private String telefono;
    private String contrasena;
    private Boolean estado;

    public ClienteTestDataBuilder() {
        this.id = ID;
        this.identificacion = IDENTIFICACION;
        this.nombre = NOMBRE;
        this.genero = GENERO;
        this.edad = EDAD;
        this.direccion = DIRECCION;
        this.telefono = TELEFONO;
        this.contrasena = CONTRASENA;
        this.estado = ESTADO;
    }

    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder conIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteTestDataBuilder conGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public ClienteTestDataBuilder conEdad(Integer edad) {
        this.edad = edad;
        return this;
    }

    public ClienteTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ClienteTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteTestDataBuilder conContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public ClienteTestDataBuilder conEstado(Boolean estado) {
        this.estado = estado;
        return this;
    }

    public Cliente construir() {
        return new Cliente(id, identificacion, nombre, genero, edad,
                direccion, telefono, contrasena, estado);
    }

    public DtoCliente construirDto() {
        return new DtoCliente(this.id, this.identificacion, this.nombre, this.genero, this.edad,
            this.direccion, this.telefono, this.contrasena, this.estado);
    }

}
