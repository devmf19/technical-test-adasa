package sa.ada.technicalTest.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import sa.ada.technicalTest.dto.in.ApplicationInDto;
import sa.ada.technicalTest.dto.out.ApplicationOutDto;
import sa.ada.technicalTest.mapper.ApplicationMapper;
import sa.ada.technicalTest.model.Application;
import sa.ada.technicalTest.model.Version;
import sa.ada.technicalTest.repository.ApplicationRepository;
import sa.ada.technicalTest.repository.VersionRepository;
import sa.ada.technicalTest.service.ApplicationService;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final VersionRepository versionRepository;
    private final ApplicationMapper applicationMapper;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository, VersionRepository versionRepository, ApplicationMapper applicationMapper) {
        this.applicationRepository = applicationRepository;
        this.versionRepository = versionRepository;
        this.applicationMapper = applicationMapper;
    }

    @Override
    public List<ApplicationOutDto> findAllApplications() {
        return applicationMapper.toDtoList(
                applicationRepository.findAll()
        );
    }

    @Override
    public ApplicationOutDto findApplicationByCode(String appCode) {
        return applicationMapper.toDto(
                applicationRepository.findApplicationByAppCode(appCode).orElseThrow(
                        () -> new EntityNotFoundException("Not found application with code "+appCode)
                )
        );
    }

    @Override
    public ApplicationOutDto saveApplication(ApplicationInDto application) {
        try {
            return applicationMapper.toDto(
                    applicationRepository.save(
                            applicationMapper.toEntity(application)
                    )
            );
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    @Override
    public boolean deleteApplication(String appCode) {
        Application application = applicationRepository.findApplicationByAppCode(appCode).orElseThrow(
                () -> new EntityNotFoundException("Not found application with code "+appCode)
        );

        if(versionRepository.findVersionByAppId(application.getAppId()).isPresent()) {
            return false;
        }

        applicationRepository.delete(application);
        return true;
    }
}
