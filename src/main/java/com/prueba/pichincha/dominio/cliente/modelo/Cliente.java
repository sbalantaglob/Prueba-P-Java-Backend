package com.prueba.pichincha.dominio.cliente.modelo;

import com.prueba.pichincha.dominio.cliente.modelo.Persona;
import com.prueba.pichincha.dominio.excepcion.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Persona {

    private Long id;
    private String contrasena;
    private Boolean estado;

    public Cliente(Long id, Integer identificacion, String nombre, String genero, Integer edad, String direccion, String telefono,
                    String contrasena, Boolean estado) {
        super(identificacion, nombre, genero, edad, direccion, telefono);
        this.id = id;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Cliente(Integer identificacion, String nombre, String genero, Integer edad, String direccion, String telefono,
                   String contrasena, Boolean estado) {
        super(identificacion, nombre, genero, edad, direccion, telefono);
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public static Cliente reconstruir(Long id, Integer identificacion, String nombre, String genero, Integer edad,
                                      String direccion, String telefono, String contrasena, Boolean estado) {
        ValidadorArgumento.validarObligatorio(identificacion, "La identificacion del cliente es obligatoria.");
        ValidadorArgumento.validarObligatorio(nombre, "El nombre del cliente es obligatorio.");
        ValidadorArgumento.validarObligatorio(contrasena, "La contrasena del cliente es obligatoria.");
        ValidadorArgumento.validarObligatorio(estado, "El estado del cliente es obligatoria.");
        return new Cliente(id, identificacion, nombre, genero, edad,
                direccion, telefono, contrasena, estado);
    }

}
