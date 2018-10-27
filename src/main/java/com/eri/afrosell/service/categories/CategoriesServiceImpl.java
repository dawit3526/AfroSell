/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eri.afrosell.service.categories;
import com.eri.afrosell.model.Category;
import com.eri.afrosell.repositories.CategoryRepository;
import com.eri.afrosell.repositories.specifications.CategorySpecifications;
import com.eri.afrosell.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tungn
 */
@Service
public class CategoriesServiceImpl extends AbstractBaseService implements CategoriesService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private CategorySpecifications categorySpecifications;


    @Override
    public Category saveOrUpdate(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> saveOrUpdate(List<Category> categories) {
        return (List<Category>) categoryRepository.save(categories);
    }

    @Override
    public Category getActiveById(long categoryId) {
        return categoryRepository.findByCategoryIdAndStatus(categoryId, 1);
    }

    @Override
    public List<Category> getAllActiveByIdsAndCompanyId(List<Long> categoryIds, long companyId) {
        return categoryRepository.findAllByCategoryIdInAndCompanyIdAndStatus(categoryIds, companyId, 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Page<Category> getAllActiveWithFilterSearchSort(long companyId, String keyword, int pageNumber, int pageSize, int sortCase, boolean ascSort) {
        Pageable pageable = new PageRequest(pageNumber - 1, pageSize);

        // create specification
        Specification spec = categorySpecifications.doFilterSearchSort(companyId, keyword, sortCase, ascSort);
        return categoryRepository.findAll(spec, pageable);
    }

}
