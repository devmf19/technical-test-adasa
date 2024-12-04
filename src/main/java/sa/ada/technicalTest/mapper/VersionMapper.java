package sa.ada.technicalTest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sa.ada.technicalTest.dto.in.VersionInDto;
import sa.ada.technicalTest.dto.out.VersionOutDto;
import sa.ada.technicalTest.model.Version;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VersionMapper {
    @Mapping(target = "versionId", ignore = true)
    Version toEntity(VersionInDto application);
    VersionOutDto toDto(Version application);
    List<VersionOutDto> toDtoList(List<Version> versionsList);
}
