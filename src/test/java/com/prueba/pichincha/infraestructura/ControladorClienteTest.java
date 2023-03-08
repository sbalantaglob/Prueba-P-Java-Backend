package com.prueba.pichincha.infraestructura;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.pichincha.aplicacion.dto.DtoCliente;
import com.prueba.pichincha.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorClienteTest {

    public static final Integer ID_TO_DELETE = 1;
    public static final Integer NUEVA_IDENTIFICACION = 123456;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void crearCliente() throws Exception {
        DtoCliente dtoCliente = new ClienteTestDataBuilder().construirDto();
        mvc.perform(MockMvcRequestBuilders
                        .post("/clientes")
                        .content(objectMapper.writeValueAsString(dtoCliente))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders
                        .get("/clientes/{identificacion}", NUEVA_IDENTIFICACION)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificacion").value(NUEVA_IDENTIFICACION));
    }

    @Test
    public void eliminarClientePorId() throws Exception {
        DtoCliente dtoCliente = new ClienteTestDataBuilder().construirDto();
        mvc.perform(MockMvcRequestBuilders
                        .post("/clientes")
                        .content(objectMapper.writeValueAsString(dtoCliente))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders
                        .delete("/clientes/{id}", NUEVA_IDENTIFICACION)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
