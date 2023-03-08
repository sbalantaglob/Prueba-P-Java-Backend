package com.prueba.pichincha.aplicacion.fabrica;

import com.prueba.pichincha.aplicacion.dto.DtoCuenta;
import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import org.springframework.stereotype.Component;

@Component
public class FabricaCuenta {

    public Cuenta crearCuenta(DtoCuenta dtoCuenta) {
        return new Cuenta(dtoCuenta.getNumeroCuenta(), dtoCuenta.getTipoCuenta(), dtoCuenta.getSaldoInicial(),
                dtoCuenta.getEstado(), dtoCuenta.getCliente());
    }

}
