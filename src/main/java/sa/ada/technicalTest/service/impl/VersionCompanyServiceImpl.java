package sa.ada.technicalTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.ada.technicalTest.repository.VersionCompanyRepository;
import sa.ada.technicalTest.service.VersionCompanyService;

@Service
public class VersionCompanyServiceImpl implements VersionCompanyService {
    private final VersionCompanyRepository versionCompanyRepository;

    @Autowired
    public VersionCompanyServiceImpl(VersionCompanyRepository versionCompanyRepository) {
        this.versionCompanyRepository = versionCompanyRepository;
    }
}
