package com.prueba.pichincha.dominio.utils;

import com.prueba.pichincha.dominio.excepcion.ExcepcionSinSaldo;

public class UtilsDominio {

    public static final String DEBITO = "Debito";
    public static final String CREDITO = "Credito";
    public static final String SIN_SALDO = "No puede realizar un movimiento de debito sin saldo.";

    public static void validarSaldoDebito(Integer saldo) {
        if (saldo.equals(0)) {
            throw new ExcepcionSinSaldo(SIN_SALDO);
        }
    }

}
