package sa.ada.technicalTest.service;

import sa.ada.technicalTest.dto.in.CompanyInDto;
import sa.ada.technicalTest.dto.out.CompanyOutDto;
import sa.ada.technicalTest.dto.out.CompanyOutDto;

import java.util.List;

public interface CompanyService {
    public List<CompanyOutDto> findAllCompanys();
    public CompanyOutDto findByCode (String companyCode);
    public CompanyOutDto saveCompany(CompanyInDto company);
    public boolean deleteCompany(String companyCode);
}
