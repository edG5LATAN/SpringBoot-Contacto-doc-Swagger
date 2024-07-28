package com.proyecto.mapeamineto.demo.domain.model.direccion;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.mapeamineto.demo.domain.model.contacto.Contacto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id_dir;
    private String ciudad;
    private String colonia;
    @OneToOne(fetch = FetchType.EAGER,targetEntity = Contacto.class,mappedBy = "direccion")
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_contacto_id"),name = "id_contacto",referencedColumnName = "id_contacto",columnDefinition = "Long")
    private Contacto contacto;

    public Direccion(DatosDireccion direccion) {
        this.ciudad= direccion.ciudad();
        this.colonia= direccion.colonia();
    }
}

