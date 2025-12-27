package ec.com.cefr.carga_archivos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name="campania")
public class Campania {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "codigo_campania", nullable = false)
    private Long codigoCampania;

    @Size(max = 5)
    @Column(name = "acronimo", length = 5)
    private String acronimo;

    @Size(max = 13)
    @Column(name = "ruc", nullable = false, length = 13)
    private String ruc;

    @Size(max = 100)
    @Column(name = "nombre_empresa", length = 100)
    private String nombreEmpresa;

    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "numero_clientes")
    private Integer numeroClientes;

    @Column(name = "presupuesto")
    private Double presupuesto;

}
