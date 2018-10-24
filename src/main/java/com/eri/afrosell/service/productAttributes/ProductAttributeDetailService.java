package com.eri.afrosell.service.productAttributes;
import com.eri.afrosell.model.ProductAttributeDetail;
import com.eri.afrosell.repositories.ProductAttributeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAttributeDetailService {

    @Autowired
    private ProductAttributeDetailRepository productAttributeDetailRepository;

    public Iterable<ProductAttributeDetail> findAllByProductId(long productId) {
        return productAttributeDetailRepository.findAllByProductId(productId);
    }

    public ProductAttributeDetail findByProductIdAndAttributeId(long productId, long attributeId) {
        return productAttributeDetailRepository.findByProductIdAndAttributeId(productId, attributeId);
    }

}
