package sa.ada.technicalTest.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationOutDto {
    private int appId;
    private String appCode;
    private String appName;
    private String appDescription;
}