package sa.ada.technicalTest.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import sa.ada.technicalTest.dto.in.VersionInDto;
import sa.ada.technicalTest.dto.out.VersionOutDto;
import sa.ada.technicalTest.mapper.VersionMapper;
import sa.ada.technicalTest.model.Version;
import sa.ada.technicalTest.repository.VersionCompanyRepository;
import sa.ada.technicalTest.repository.VersionRepository;
import sa.ada.technicalTest.service.VersionService;

import java.util.List;

@Service
public class VersionServiceImpl implements VersionService {
    private final VersionRepository versionRepository;
    private final VersionCompanyRepository versionCompanyRepository;
    private final VersionMapper versionMapper;

    @Autowired
    public VersionServiceImpl(VersionRepository versionRepository, VersionCompanyRepository versionCompanyRepository, VersionMapper versionMapper) {
        this.versionRepository = versionRepository;
        this.versionCompanyRepository = versionCompanyRepository;
        this.versionMapper = versionMapper;
    }

    @Override
    public List<VersionOutDto> findAllVersions() {
        return versionMapper.toDtoList(
                versionRepository.findAll()
        );
    }

    @Override
    public VersionOutDto findVersionByVersion(String version) {
        return versionMapper.toDto(
                versionRepository.findByVersionContaining(version).orElseThrow(
                        () -> new EntityNotFoundException("Not found version " + version)
                )
        );
    }

    @Override
    public VersionOutDto saveVersion(VersionInDto version) {
        try {
            return versionMapper.toDto(
                    versionRepository.save(
                            versionMapper.toEntity(version)
                    )
            );
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteVersion(int versionId) {
        Version version = versionRepository.findById(versionId).orElseThrow(
                () -> new EntityNotFoundException("Not found version with id" + versionId)
        );

        versionCompanyRepository.deleteAll(versionCompanyRepository.findVersionCompanyByVersionId(version.getVersionId()));
        versionRepository.delete(version);
        return true;
    }
}
