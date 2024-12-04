package sa.ada.technicalTest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "application")
@Getter
@Setter
public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private int appId;

    @Column(name = "app_code", unique = true)
    private String appCode;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "app_description")
    private String appDescription;
}
