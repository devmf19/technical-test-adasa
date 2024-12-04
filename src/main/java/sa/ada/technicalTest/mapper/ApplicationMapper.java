package sa.ada.technicalTest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sa.ada.technicalTest.dto.in.ApplicationInDto;
import sa.ada.technicalTest.dto.out.ApplicationOutDto;
import sa.ada.technicalTest.model.Application;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    @Mapping(target = "appId", ignore = true)
    Application toEntity(ApplicationInDto application);
    ApplicationOutDto toDto(Application application);

    List<ApplicationOutDto> toDtoList(List<Application> applicationList);
}
