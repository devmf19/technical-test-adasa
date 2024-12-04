package sa.ada.technicalTest.dto.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VersionInDto {
    private int versionId;
    private int appId;
    private String version;
    private String version_description;
}
