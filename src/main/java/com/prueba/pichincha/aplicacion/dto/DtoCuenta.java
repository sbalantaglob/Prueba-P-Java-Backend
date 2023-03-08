package com.prueba.pichincha.aplicacion.dto;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DtoCuenta {

    private Long id;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Integer saldoInicial;
    private Boolean estado;
    private Cliente cliente;

}
