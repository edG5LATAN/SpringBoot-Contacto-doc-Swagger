package com.proyecto.mapeamineto.demo.domain.model.contacto;

import com.proyecto.mapeamineto.demo.domain.model.direccion.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "contacto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Long id_con;
    private String nombre;
    @Column(unique = true)
    private String correo;
    private String telefono;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id-dire",referencedColumnName = "id_direccion")
    private Direccion direccion;

    public Contacto(DatosContacto datosContacto) {
        this.nombre= datosContacto.nombre();
        this.correo= datosContacto.correo();
        this.telefono= datosContacto.telefono();
        this.direccion=new Direccion(datosContacto.datosDireccion());
    }
}
