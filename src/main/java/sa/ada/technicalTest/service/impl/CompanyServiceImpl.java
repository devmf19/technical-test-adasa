package sa.ada.technicalTest.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import sa.ada.technicalTest.dto.in.CompanyInDto;
import sa.ada.technicalTest.dto.out.CompanyOutDto;
import sa.ada.technicalTest.mapper.CompanyMapper;
import sa.ada.technicalTest.model.Application;
import sa.ada.technicalTest.model.Company;
import sa.ada.technicalTest.model.Version;
import sa.ada.technicalTest.model.VersionCompany;
import sa.ada.technicalTest.repository.ApplicationRepository;
import sa.ada.technicalTest.repository.CompanyRepository;
import sa.ada.technicalTest.repository.VersionCompanyRepository;
import sa.ada.technicalTest.repository.VersionRepository;
import sa.ada.technicalTest.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final VersionCompanyRepository versionCompanyRepository;
    private final VersionRepository versionRepository;
    private final ApplicationRepository applicationRepository;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, VersionCompanyRepository versionCompanyRepository, VersionRepository versionRepository, ApplicationRepository applicationRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.versionCompanyRepository = versionCompanyRepository;
        this.versionRepository = versionRepository;
        this.applicationRepository = applicationRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyOutDto> findAllCompanys() {
        return companyMapper.toDtoList(
                companyRepository.findAll()
        );
    }

    @Override
    public CompanyOutDto findByCode(String companyCode) {
        Company company = companyRepository.findCompanyByCodigoCompany(companyCode)
                .orElseThrow(
                        () -> new EntityNotFoundException("Not found company with code: "+ companyCode)
                );

        CompanyOutDto response  = new CompanyOutDto();
        response.setCodigoCompany(company.getCodigoCompany());
        response.setNameCompany(company.getNameCompany());

        if (versionCompanyRepository.findVersionCompanyByCompanyId(company.getIdCompany()).isPresent()){
            VersionCompany versionCompany = versionCompanyRepository.findVersionCompanyByCompanyId(company.getIdCompany()).get();
            Version version = versionRepository.findById(versionCompany.getVersionId()).get();
            Application application = applicationRepository.findById(version.getAppId()).get();

            response.setVersion(version.getVersion());
            response.setAppName(application.getAppName());
        };

        return response;
    }

    @Override
    @Transactional
    public CompanyOutDto saveCompany(CompanyInDto company) {
        Application application = applicationRepository.findById(company.getIdApplication()).orElseThrow(
                () -> new EntityNotFoundException("Not found application with id "+company.getIdApplication())
        );

        Version version = versionRepository.findVersionByAppIdAndVersionId(company.getIdApplication(), company.getIdVersion()).orElseThrow(
                () -> new EntityNotFoundException("Not found a version with id "+company.getIdApplication() + " for indicated application")
        );

        CompanyOutDto response = new CompanyOutDto();

        if (versionCompanyRepository.findVersionCompanyByCompanyId(company.getIdCompany()).isPresent()) {
            try {
                VersionCompany versionCompany = versionCompanyRepository.findVersionCompanyByCompanyId(company.getIdCompany()).get();
                versionCompany.setVersionId(company.getIdVersion());
                versionCompany.setVersionCompanyDescription(company.getVersionCompanyDescription());

                versionCompanyRepository.save(versionCompany);
                Company entityCompany = companyRepository.findById(company.getIdCompany()).get();
                entityCompany.setNameCompany(company.getNameCompany());
                entityCompany.setDescriptionCompany(company.getDescriptionCompany());
                entityCompany.setCodigoCompany(company.getCodigoCompany());

                response = companyMapper.toDto(companyRepository.save(entityCompany));
                response.setVersion(version.getVersion());
                response.setAppName(application.getAppName());

                return response;

            } catch (DataIntegrityViolationException e) {
                return null;
            }
        }

        try {
            Company entityCompany = companyRepository.save(companyMapper.toEntity(company));
            response = companyMapper.toDto(
                    entityCompany
            );
            response.setVersion(version.getVersion());
            response.setAppName(application.getAppName());

            VersionCompany versionCompany = new VersionCompany();
            versionCompany.setCompanyId(entityCompany.getIdCompany());
            versionCompany.setVersionId(company.getIdVersion());
            versionCompany.setVersionCompanyDescription(company.getVersionCompanyDescription());

            versionCompanyRepository.save(versionCompany);

            return response;

        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteCompany(String companyCode) {
        Company company = companyRepository.findCompanyByCodigoCompany(companyCode)
                .orElseThrow(
                        () -> new EntityNotFoundException("Not found company with code: "+ companyCode)
                );

        versionCompanyRepository.delete(versionCompanyRepository.findVersionCompanyByCompanyId(company.getIdCompany()).get());
        companyRepository.delete(company);
        return true;
    }


}
