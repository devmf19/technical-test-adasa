package sa.ada.technicalTest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.ada.technicalTest.dto.ResponseDto;
import sa.ada.technicalTest.dto.in.CompanyInDto;
import sa.ada.technicalTest.dto.out.CompanyOutDto;
import sa.ada.technicalTest.service.CompanyService;

@RestController
@RequestMapping("/api/company")
@Tag(name = "Companies", description = "Companies controller")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/search/{companyCode}")
    public ResponseEntity<ResponseDto<CompanyOutDto>> findByCode(@PathVariable("companyCode") String companyCode) {
        return new ResponseEntity<>(
                ResponseDto.<CompanyOutDto>builder()
                        .data(companyService.findByCode(companyCode))
                        .status(HttpStatus.OK)
                        .message("Success operation")
                        .build(),
                HttpStatus.OK
        );
    }

    @PostMapping("/save/")
    public ResponseEntity<ResponseDto<CompanyOutDto>> saveCompany(@RequestBody CompanyInDto company) {
        return new ResponseEntity<>(
                ResponseDto.<CompanyOutDto>builder()
                        .data(companyService.saveCompany(company))
                        .status(HttpStatus.CREATED)
                        .message("Success operation")
                        .build(),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update/")
    public ResponseEntity<ResponseDto<CompanyOutDto>> updateCompany(@RequestBody CompanyInDto company) {
        return new ResponseEntity<>(
                ResponseDto.<CompanyOutDto>builder()
                        .data(companyService.saveCompany(company))
                        .status(HttpStatus.CREATED)
                        .message("Success operation")
                        .build(),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete/{companyCode}")
    public ResponseEntity<ResponseDto<Boolean>> deleteCompany(@PathVariable("companyCode") String companyCode) {
        return new ResponseEntity<>(
                ResponseDto.<Boolean>builder()
                        .data(companyService.deleteCompany(companyCode))
                        .status(HttpStatus.OK)
                        .message("---------")
                        .build(),
                HttpStatus.OK
        );
    }

}
