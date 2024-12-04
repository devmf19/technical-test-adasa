package sa.ada.technicalTest.dto.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationInDto {
    private int appId;
    private String appCode;
    private String appName;
    private String appDescription;
}
