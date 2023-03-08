package com.prueba.pichincha.infraestructura.persistencia.entidad;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movimiento")
public class MovimientoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 20)
    private String tipoMovimiento;
    @Column(nullable = false)
    private Integer valor;
    @Column(nullable = false)
    private Integer saldo;
    @Column(nullable = false)
    private Timestamp fecha;
    @OneToOne(optional = false)
    private CuentaEntidad cuentaEntidad;

    @PrePersist
    private void actualizarFechaMovimiento () {
        fecha = Timestamp.from(Instant.now());
    }


}
