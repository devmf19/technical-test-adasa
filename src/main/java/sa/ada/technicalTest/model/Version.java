package sa.ada.technicalTest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "version")
@Getter
@Setter
public class Version implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private int versionId;

    @Column(name = "app_id", unique = true)
    private int appId;

    @Column(name = "version")
    private String version;

    @Column(name = "version_description")
    private String version_description;
}
