package sa.ada.technicalTest.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VersionOutDto {
    private int versionId;
    private int appId;
    private String version;
    private String version_description;
}