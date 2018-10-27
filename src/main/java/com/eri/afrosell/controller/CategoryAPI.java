package com.eri.afrosell.controller;
import com.eri.afrosell.model.Category;
import com.eri.afrosell.repositories.CategoryRepository;
import com.eri.afrosell.response.APIResponse;
import com.eri.afrosell.response.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author NHU LINH
 */
@RestController
@Api(value = "category API")
public class CategoryAPI  {
    @Autowired
    CategoryRepository repository;

    @Autowired
    protected ResponseUtil responseUtil;

    @ApiOperation(value = "getCategory")
    @RequestMapping(value = APINames.CATEGORIES, method = RequestMethod.GET, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> getCategories(@PathVariable Long company_id) {
        List<Category> categories = (List<Category>) repository.findByCompanyId(company_id);
        return responseUtil.successResponse(categories);
    }

    @RequestMapping(value = APINames.CATEGORIES, method = RequestMethod.POST, produces = APINames.CHARSET)
    @ResponseBody
    public ResponseEntity<APIResponse> addCatrgory(@PathVariable Long company_id,
                              @RequestParam(name = "parent_id", required = false) Long ParentID,
                              @RequestParam(name = "name", required = true) String name,
                              @RequestParam(name = "status", required = false) Integer Status,
                              @RequestParam(name = "position", required = false) Integer position,
                              @RequestParam(name = "description", required = false) String description) {
        Category category = new Category();
        category.setCompanyId(company_id);
        category.setParentId(ParentID);
        category.setName(name);
        category.setStatus(Status);
        category.setPosition(position);
        category.setDescription(description);
        repository.save(category);
        return responseUtil.successResponse(category);
    }

    @RequestMapping(value = APINames.CATEGORIES_ID, method = RequestMethod.DELETE, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> deleteCategory(@PathVariable(value = "id") Long categoryId) {
        System.out.println("category " + categoryId);
        Category category = repository.findByCategoryId(categoryId);
        if (category != null) {
            repository.delete(category);
            responseUtil.successResponse(category);
        } else {
            responseUtil.successResponse("not found");
        }
        return responseUtil.successResponse(category);
    }

    @RequestMapping(value = APINames.CATEGORIES_ID, method = RequestMethod.PUT, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> updateCategory(@PathVariable Long companyId,
                                 @PathVariable(value = "id") Long categoryId,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "status", required = false) Integer status,
                                 @RequestParam(name = "parent_id", required = false) Long ParentID,
                                 @RequestParam(name = "position", required = false) Integer position,
                                 @RequestParam(name = "description", required = false) String description) {
        Category category = repository.findByCategoryId(categoryId);
        if (category != null) {
            if (!name.equals("")) {
                category.setName(name);
            } else {
               responseUtil.successResponse( "update name no successfully");
                return responseUtil.successResponse(category);
            }
            if (ParentID != null) {
                Category parent = repository.findOne(ParentID);
                if (parent != null && parent.getCompanyId() == category.getCompanyId()) {
                    category.setParentId(ParentID);
                } else {
                    responseUtil.successResponse("update parent_id no successfully");
                    return responseUtil.successResponse(category);
                }
            }
            if (status != null) {
                category.setStatus(status);
            }
            if (position != null) {
                category.setPosition(position);
            }
            if (description != null) {
                category.setDescription(description);
            }
            repository.save(category);
          responseUtil.successResponse(category);
        }
        return responseUtil.successResponse(category);
    }
}
