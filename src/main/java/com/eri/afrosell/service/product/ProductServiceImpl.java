package com.eri.afrosell.service.product;
import com.eri.afrosell.model.Product;
import com.eri.afrosell.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> getByCompanyId(long companyId, int pageNumber, int pageSize) {
        return productRepository.findByCompanyId(companyId, new PageRequest(pageNumber, pageSize));
    }

    @Override
    public Product getProductById(long companyId, long productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public Iterable<Product> getProductsById(long companyId, List<Long> productIds) {
        return productRepository.findByProductIds(companyId,productIds);
    }

}
