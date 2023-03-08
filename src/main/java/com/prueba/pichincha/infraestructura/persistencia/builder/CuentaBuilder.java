package com.prueba.pichincha.infraestructura.persistencia.builder;

import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.infraestructura.persistencia.entidad.ClienteEntidad;
import com.prueba.pichincha.infraestructura.persistencia.entidad.CuentaEntidad;

import java.util.Objects;

public final class CuentaBuilder {

    private CuentaBuilder() {
    }
    
    public static Cuenta convertirADominio(CuentaEntidad cuentaEntidad) {
        Cuenta cuenta = new Cuenta();
        if (Objects.nonNull(cuentaEntidad) ) {
            cuenta = new Cuenta(Objects.nonNull(cuentaEntidad.getId()) ? cuenta.getId() : null, cuentaEntidad.getNumeroCuenta(),
                    cuentaEntidad.getTipoCuenta(), cuentaEntidad.getSaldoInicial(), cuentaEntidad.getEstado(),
                    ClienteBuilder.convertirADominio(cuentaEntidad.getClienteEntidad()));
        }
        return cuenta;
    }

    public static CuentaEntidad convertirAEntidad(Cuenta cuenta) {
        CuentaEntidad cuentaEntidad = new CuentaEntidad();
        cuentaEntidad.setId(Objects.nonNull(cuenta.getId()) ? cuenta.getId() : null);
        cuentaEntidad.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaEntidad.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaEntidad.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaEntidad.setEstado(cuenta.getEstado());
        cuentaEntidad.setClienteEntidad(ClienteBuilder.convertirAEntidad(cuenta.getCliente()));
        return cuentaEntidad;
    }
    
}
