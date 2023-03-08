package com.prueba.pichincha.dominio.excepcion;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class ValidadorArgumento {

    public static void validarSaldo(BigDecimal valor, String mensaje) {
        Integer resultado = valor.compareTo(BigDecimal.ZERO);
        if ( resultado ==  -1 || resultado == 0 ) {
            throw new ExcepcionSinSaldo(mensaje);
        }
    }

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarLongitud(String valor,int longitud,String mensaje){
        if(valor.length() < longitud){
            throw new ExcepcionLongitudValor(mensaje);
        }
    }

}
