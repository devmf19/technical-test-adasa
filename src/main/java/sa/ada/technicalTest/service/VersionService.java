package sa.ada.technicalTest.service;

import sa.ada.technicalTest.dto.in.VersionInDto;
import sa.ada.technicalTest.dto.out.VersionOutDto;

import java.util.List;

public interface VersionService {
    public List<VersionOutDto> findAllVersions();
    public VersionOutDto findVersionByVersion(String version);
    public VersionOutDto saveVersion(VersionInDto version);
    public boolean deleteVersion(int versionId);
}
