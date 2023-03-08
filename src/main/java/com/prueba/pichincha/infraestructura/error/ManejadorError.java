package com.prueba.pichincha.infraestructura.error;

import com.prueba.pichincha.dominio.excepcion.ExcepcionSinDatos;
import com.prueba.pichincha.dominio.excepcion.ExcepcionSinSaldo;
import com.prueba.pichincha.dominio.excepcion.ExcepcionValorObligatorio;
import com.prueba.pichincha.dominio.excepcion.ExcepcionYaExiste;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";

    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError() {
        CODIGOS_ESTADO.put(ExcepcionSinSaldo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionValorObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionSinDatos.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(ExcepcionYaExiste.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> manejadorTodasExcepciones(Exception exception) {

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (Objects.nonNull(codigo)) {
            Error error = new Error(excepcionNombre, mensaje);
            return new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
