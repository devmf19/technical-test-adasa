package sa.ada.technicalTest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "version_company")
@Getter
@Setter
public class VersionCompany implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_company_id")
    private int versionCompanyId;

    @Column(name = "company_id", unique = true)
    private int companyId;

    @Column(name = "version_id")
    private int versionId;

    @Column(name = "version_company_description")
    private String versionCompanyDescription;
}
