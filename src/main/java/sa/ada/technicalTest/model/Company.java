package sa.ada.technicalTest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private int idCompany;

    @Column(name = "codigo_company", unique = true)
    private String codigoCompany;

    @Column(name = "name_company")
    private String nameCompany;

    @Column(name = "description_company")
    private String descriptionCompany;
}
