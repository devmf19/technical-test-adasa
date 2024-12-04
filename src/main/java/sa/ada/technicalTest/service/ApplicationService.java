package sa.ada.technicalTest.service;

import sa.ada.technicalTest.dto.in.ApplicationInDto;
import sa.ada.technicalTest.dto.out.ApplicationOutDto;

import java.util.List;

public interface ApplicationService {
    public List<ApplicationOutDto> findAllApplications();
    public ApplicationOutDto findApplicationByCode(String appCode);
    public ApplicationOutDto saveApplication(ApplicationInDto application);
    public boolean deleteApplication(String appCode);

}
