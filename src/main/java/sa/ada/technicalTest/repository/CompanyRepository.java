package sa.ada.technicalTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sa.ada.technicalTest.dto.out.CompanyOutDto;
import sa.ada.technicalTest.model.Company;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    public Optional<Company> findCompanyByCodigoCompany(String companyCode);
}
