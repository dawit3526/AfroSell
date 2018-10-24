/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eri.afrosell.service.productAttributes;

import com.eri.afrosell.model.CreateAttributeModel;
import com.eri.afrosell.model.ProductAttribute;
import com.eri.afrosell.model.ProductAttributeDetail;
import com.eri.afrosell.repositories.ProductAttributeDetailRepository;
import com.eri.afrosell.repositories.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NHU LINH
 */
@Service
public class ProductAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Autowired
    private ProductAttributeDetailRepository productAttributeDetailRepository;

    public Iterable<ProductAttribute> findAll() {
        return productAttributeRepository.findAll();
    }

    public ProductAttribute save(CreateAttributeModel productAttributes){
        ProductAttribute productAttribute = new ProductAttribute();
        productAttribute.setAttributeId(productAttributes.getAttributeId());
        productAttribute.setCompanyId(productAttributes.getCompanyId());
        productAttribute.setName(productAttributes.getName());
        productAttributeRepository.save(productAttribute);
        ProductAttributeDetail productAttributeDetail = new ProductAttributeDetail();
        productAttributeDetail.setAttributeId(productAttributes.getAttributeId());
        productAttributeDetail.setProductId(productAttributes.getProductId());
        productAttributeDetail.setValueNumberic(productAttributes.getValueNumberic());
        productAttributeDetail.setValueString(productAttributes.getValueString());
        productAttributeDetailRepository.save(productAttributeDetail);
        return productAttribute;
    }
}
