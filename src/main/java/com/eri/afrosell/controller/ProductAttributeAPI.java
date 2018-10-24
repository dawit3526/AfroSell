/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eri.afrosell.controller;
import com.eri.afrosell.exceptions.ApplicationException;
import com.eri.afrosell.model.CreateAttributeModel;
import com.eri.afrosell.model.ProductAttribute;
import com.eri.afrosell.model.ProductAttributeDetail;
import com.eri.afrosell.response.APIResponse;
import com.eri.afrosell.response.util.APIStatus;
import com.eri.afrosell.response.util.ResponseUtil;
import com.eri.afrosell.service.productAttributes.ProductAttributeDetailService;
import com.eri.afrosell.service.productAttributes.ProductAttributeService;
import com.eri.afrosell.util.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author NHU LINH
 */
@RestController
@Api(value = "Productattribute API")
@RequestMapping(APINames.VERSION)
public class ProductAttributeAPI {

    @Autowired
    ProductAttributeService productAttributeService;

    @Autowired
    ProductAttributeDetailService productAttributeDetailService;
    @Autowired
    protected ResponseUtil responseUtil;

    @ApiOperation(value = "getProductAttribute")
    @RequestMapping(value = APINames.PRODUCT_ATTRIBUTES, method = RequestMethod.GET, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> getProductAttribute() {

        List<ProductAttribute> productattribute = (List<ProductAttribute>) productAttributeService.findAll();
        return responseUtil.successResponse(productattribute);

    }

    @ApiOperation(value = "getProductDetail")
    @RequestMapping(value = APINames.PRODUCT_DETAILS, method = RequestMethod.GET, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> getProductDetail(@PathVariable(value = "product_id") Long productId) {

        List<ProductAttributeDetail> productdetails = (List<ProductAttributeDetail>) productAttributeDetailService.findAllByProductId(productId);
        if (productdetails != null) {
            return responseUtil.successResponse(productdetails);
        } else {
            responseUtil.successResponse("Not found");
        }

        return responseUtil.successResponse(productdetails);
    }

    @ApiOperation(value = "AddProductAttributes")
    @RequestMapping(value = APINames.PRODUCT_ATTRIBUTES_CREATE,method = RequestMethod.POST, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> setProductAttributes(@RequestBody CreateAttributeModel createAttributeModel){
        ProductAttribute productAttribute = null;
        try {
            if (createAttributeModel != null) {
             productAttribute = productAttributeService.save(createAttributeModel);
            }

        }
        catch (Exception e){
            throw new ApplicationException(APIStatus.CREATE_PRODUCTATTRIBUTE_ERROR);
        }
        return  responseUtil.successResponse(productAttribute);
    }

}
