package com.prueba.pichincha.dominio.cuenta.modelo;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.excepcion.ValidadorArgumento;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {

    private Long id;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Integer saldoInicial;
    private Boolean estado;
    private Cliente cliente;

    public Cuenta(Long numeroCuenta, String tipoCuenta, Integer saldoInicial, Boolean estado, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.cliente = cliente;
    }

    public static Cuenta reconstruir(Long id, Long numeroCuenta, String tipoCuenta, Integer saldoInicial,
                                     Boolean estado, Cliente cliente) {
        ValidadorArgumento.validarObligatorio(id, "El id de la cuenta es obligatorio.");
        ValidadorArgumento.validarObligatorio(numeroCuenta, "El numero de cuenta es obligatorio.");
        ValidadorArgumento.validarObligatorio(tipoCuenta, "El tipo de cuenta es obligatorio.");
        ValidadorArgumento.validarLongitud(tipoCuenta, 20,
                "Maximo tamanio del tipo de cuenta es 20 caracteres.");
        ValidadorArgumento.validarObligatorio(saldoInicial, "El estado del cliente es obligatoria.");
        ValidadorArgumento.validarObligatorio(estado, "El estado del cliente es obligatoria.");
        ValidadorArgumento.validarObligatorio(cliente, "El estado del cliente es obligatoria.");
        return new Cuenta(id, numeroCuenta, tipoCuenta, saldoInicial, estado, cliente);
    }

}
