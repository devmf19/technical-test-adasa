package sa.ada.technicalTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sa.ada.technicalTest.model.Version;

import java.util.Optional;

@Repository
public interface VersionRepository extends JpaRepository<Version, Integer> {
    public Optional<Version> findVersionByAppId(int appId);

    public Optional<Version> findByVersionContaining(String version);

    public Optional<Version> findVersionByAppIdAndVersionId(int appId, int versionId);
}
