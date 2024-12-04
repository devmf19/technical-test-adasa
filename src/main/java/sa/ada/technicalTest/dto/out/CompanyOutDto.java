package sa.ada.technicalTest.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CompanyOutDto {
    private int idCompany;
    private String codigoCompany;
    private String nameCompany;
    private String appName;
    private String version;
}
