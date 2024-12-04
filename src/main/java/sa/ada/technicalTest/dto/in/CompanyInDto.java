package sa.ada.technicalTest.dto.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyInDto {
    private int idCompany;
    private String codigoCompany;
    private String nameCompany;
    private String descriptionCompany;
    private int idApplication;
    private int idVersion;
    private String versionCompanyDescription;
}
