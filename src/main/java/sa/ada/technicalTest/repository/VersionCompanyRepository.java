package sa.ada.technicalTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sa.ada.technicalTest.model.VersionCompany;

import java.util.List;
import java.util.Optional;

@Repository
public interface VersionCompanyRepository extends JpaRepository<VersionCompany, Integer> {
    public Optional<VersionCompany> findVersionCompanyByCompanyId(int companyId);
    public List<VersionCompany> findVersionCompanyByVersionId(int companyId);
}
