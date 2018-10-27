package com.eri.afrosell.controller;

import com.eri.afrosell.exceptions.ApplicationException;
import com.eri.afrosell.model.CompanyModel;
import com.eri.afrosell.model.Company;
import com.eri.afrosell.response.APIResponse;
import com.eri.afrosell.response.util.APIStatus;
import com.eri.afrosell.response.util.ResponseUtil;
import com.eri.afrosell.service.comapeny.CompanyService;
import com.eri.afrosell.util.Constant;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CompanyAPI {

    @Autowired
    private CompanyService companyService;

    @Autowired
    protected ResponseUtil responseUtil;

    @RequestMapping(value = APINames.COMPANIES, method = RequestMethod.GET, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> getAllCompanies() {
        List<Company> companies = (List<Company>) companyService.findAll();
        return responseUtil.successResponse(companies);
    }

    @RequestMapping(value = APINames.COMPANIES_SEARCH_BY_ID, method = RequestMethod.GET, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> getCompanyById(@PathVariable(value = "id") Integer companyId) {

        Company companies = companyService.findByCompanyId(companyId);

        return responseUtil.successResponse(companies);
    }

    @ApiOperation(value = "create company")
    @RequestMapping(value = APINames.COMPANIES_CREATE,method = RequestMethod.POST, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> setProductAttributes(@RequestBody String companyName){
        Company company = null;
        try {
            if (companyName != null) {
                company = companyService.save(companyName);
            }

        }
        catch (Exception e){
            throw new ApplicationException(APIStatus.CREATE_PRODUCTATTRIBUTE_ERROR);
        }
        return  responseUtil.successResponse(company);
    }

    @ApiOperation(value = "delete company list", notes = "")
    @RequestMapping(value = APINames.COMPANIES_DELETE, method = RequestMethod.POST, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> deleteCompaney(HttpServletRequest request,
                                                     @RequestBody List<Long> company_ids) {
        try {
            for (Long id : company_ids) {
                Company company = companyService.findByCompanyId(id);
                if (company != null) {
//                //update status
                    company.setStatus(Constant.STATUS.DELETED_STATUS.getValue());
                    companyService.update(company);
                }
            }
            return responseUtil.successResponse(company_ids);
        } catch (Exception ex) {
            throw new ApplicationException(APIStatus.ERR_COMPANY_DELETE);
        }
    }



    @ApiOperation(value = "delete company list", notes = "")
    @RequestMapping(value = APINames.COMPANIES_UPDATE, method = RequestMethod.PUT, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> updateCompnay(HttpServletRequest request,
                                                     @RequestBody CompanyModel companyModel) {
        try {
                Company company = companyService.findByCompanyId(companyModel.getCompanyId());
                if (company != null) {
//                //update status
                    company.setName(companyModel.getName());
                    company.setStatus(companyModel.getStatus());
                    companyService.update(company);
                }

            return responseUtil.successResponse(company);
        } catch (Exception ex) {
            throw new ApplicationException(APIStatus.ERR_COMPANY_UPDATE);
        }
    }
}
