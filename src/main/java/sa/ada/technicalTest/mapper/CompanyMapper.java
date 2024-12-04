package sa.ada.technicalTest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sa.ada.technicalTest.dto.in.CompanyInDto;
import sa.ada.technicalTest.dto.out.CompanyOutDto;
import sa.ada.technicalTest.model.Company;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    @Mapping(target = "idCompany", ignore = true)
    Company toEntity(CompanyInDto application);
    CompanyOutDto toDto(Company application);
    List<CompanyOutDto> toDtoList(List<Company> companiesList);
}
