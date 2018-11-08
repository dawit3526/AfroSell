package com.eri.afrosell.service.comapeny;


import com.eri.afrosell.model.CompanyModel;
import com.eri.afrosell.model.Company;
import com.eri.afrosell.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findByCompanyId(long companyId) {
        return companyRepository.findByCompanyId(companyId);
    }
    public Company save(String companyName){

        Company companyObj = new Company();
        companyObj.setCompanyId(null);
        companyObj.setCreateDate(new Date());
        companyObj.setName(companyName);
        return companyRepository.save(companyObj);
    }

    public Company update(Company company){
        return  companyRepository.save(company);

    }
}

