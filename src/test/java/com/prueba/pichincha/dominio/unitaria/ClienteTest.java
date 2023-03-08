package com.prueba.pichincha.dominio.unitaria;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.testdatabuilder.ClienteTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ClienteTest {

    private static final Integer IDENTIFICACION = 78910;
    private static final String NOMBRE = "Sofia Rodriguez";
    private static final String TELEFONO = "369852147";


    @Test
    public void crearClienteTest() {

        // Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conIdentificacion(IDENTIFICACION)
                .conNombre(NOMBRE)
                .conTelefono(TELEFONO);

        // Act
        Cliente cliente = clienteTestDataBuilder.construir();

        // Assert
        assertEquals(IDENTIFICACION, cliente.getIdentificacion());
        assertEquals(NOMBRE, cliente.getNombre());
        assertEquals(TELEFONO, cliente.getTelefono());
    }

}
