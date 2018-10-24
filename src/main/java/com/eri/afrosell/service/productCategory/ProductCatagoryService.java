package com.eri.afrosell.service.productCategory;
import com.eri.afrosell.model.CreateProductModel;
import com.eri.afrosell.model.Product;
import com.eri.afrosell.model.ProductCategory;

public interface ProductCatagoryService {

    void Save(CreateProductModel productRequest, Long productId);
}
