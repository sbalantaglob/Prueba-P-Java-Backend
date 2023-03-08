package com.prueba.pichincha.infraestructura.persistencia.repositorio;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.puerto.repositorio.IRepositorioCuenta;
import com.prueba.pichincha.dominio.excepcion.ExcepcionSinDatos;
import com.prueba.pichincha.dominio.excepcion.ExcepcionYaExiste;
import com.prueba.pichincha.infraestructura.persistencia.builder.CuentaBuilder;
import com.prueba.pichincha.infraestructura.persistencia.entidad.CuentaEntidad;
import com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa.IRepositorioCuentaJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioCuenta implements IRepositorioCuenta {

    private static final String MENSAJE_CREAR_CUENTA_EXISTENTE = "Ya existe este numero de cuenta en el sistema, " +
            "por favor cambiela.";
    private static final String MENSAJE_CUENTA_NO_EXISTE = "No se pudo encontrar la cuenta, no existe.";
    private static final String MENSAJE_ELIMINAR_NO_EXISTE = "No se puedo eliminar cuenta, no existe.";

    private IRepositorioCuentaJPA repositorioCuentaJPA;

    public RepositorioCuenta(IRepositorioCuentaJPA iRepositorioCuentaJPA) {
        this.repositorioCuentaJPA = iRepositorioCuentaJPA;
    }

    @Override
    public Long guardar(Cuenta cuenta) {
        if (this.existePorNumeroCuenta(cuenta.getNumeroCuenta())) {
            throw new ExcepcionYaExiste(MENSAJE_CREAR_CUENTA_EXISTENTE);
        }
        CuentaEntidad cuentaEntidad = CuentaBuilder.convertirAEntidad(cuenta);
        cuentaEntidad = repositorioCuentaJPA.save(cuentaEntidad);
        return cuentaEntidad.getId();
    }

    @Override
    public Cuenta obtenerPorNumeroCuenta(Long numeroCuenta) {
        CuentaEntidad cuentaEntidad = repositorioCuentaJPA.
                findByNumeroCuenta(numeroCuenta).orElseThrow( () -> new ExcepcionSinDatos(MENSAJE_CUENTA_NO_EXISTE));
        return CuentaBuilder.convertirADominio(cuentaEntidad);
    }


    @Override
    public void actualizar(Cuenta cuenta) {
        CuentaEntidad cuentaEntidad = CuentaBuilder.convertirAEntidad(cuenta);
        repositorioCuentaJPA.save(cuentaEntidad);
    }

    @Override
    public void eliminar(Long id) {
        Optional<CuentaEntidad> cuentaEntidad = repositorioCuentaJPA.findById(id);
        repositorioCuentaJPA.delete(cuentaEntidad.orElseThrow(() ->
                new ExcepcionSinDatos(MENSAJE_ELIMINAR_NO_EXISTE)));
    }

    @Override
    public Boolean existePorNumeroCuenta(Long numeroCuenta) {
        return repositorioCuentaJPA.existePorNumeroCuenta(numeroCuenta);
    }
}
