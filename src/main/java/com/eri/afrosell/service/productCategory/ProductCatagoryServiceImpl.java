package com.eri.afrosell.service.productCategory;
import com.eri.afrosell.model.CreateProductModel;
import com.eri.afrosell.model.Product;
import com.eri.afrosell.model.ProductCategory;
import com.eri.afrosell.model.ProductCategoryId;
import com.eri.afrosell.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCatagoryServiceImpl implements ProductCatagoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public void Save(CreateProductModel productRequest, Long productId) {
        for (Long categoriesId : productRequest.getListCategoriesId()) {
            ProductCategoryId productCategoryId = new ProductCategoryId();
            ProductCategory productCategory = new ProductCategory();
            productCategoryId.setCategoryId(categoriesId);
            productCategoryId.setProductId(productId);
            productCategory.setId(productCategoryId);
            System.out.println("id product : " + productId.toString());
            productCategoryRepository.save(productCategory);
        }

    }
}
