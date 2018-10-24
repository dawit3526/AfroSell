package com.eri.afrosell.service.product;
import com.eri.afrosell.model.CreateProductModel;
import com.eri.afrosell.model.Product;
import com.eri.afrosell.repositories.ProductRepository;
import com.eri.afrosell.repositories.specifications.ProductSpecification;
import com.eri.afrosell.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    @Override
    public Page<Product> doFilterSearchSortPagingProduct(long comId, long catId, long attrId, String searchKey, double mnPrice, double mxPrice, int minRank, int maxRank, int sortKey, boolean isAscSort, int pSize, int pNumber) {
        return productRepository.findAll(new ProductSpecification(comId, catId, attrId, searchKey, mnPrice, mxPrice, minRank, maxRank, sortKey, isAscSort), new PageRequest(pNumber, pSize));
    }

    @Override
    public Product save(CreateProductModel productRequest, Product product) {

        product.setBrowsingName(productRequest.getBrowsingName());
        product.setCompanyId(productRequest.getCompanyId());
        product.setCreatedOn(new Date());
        product.setDefaultImage(productRequest.getDefaultImage());
        product.setDescription(productRequest.getDescription());
        product.setIsStockControlled(productRequest.getIsStockControlled());
        product.setListPrice(productRequest.getListPrice());
        product.setName(productRequest.getName());
        product.setOverview(productRequest.getOverview());
        product.setQuantity(productRequest.getQuantity());
        product.setRank(productRequest.getRank());
        product.setSalePrice(productRequest.getSalePrice());
        product.setSku(productRequest.getSku());
        product.setStatus(Constant.STATUS.ACTIVE_STATUS.getValue());
        product.setUpdatedOn(new Date());
        product.setProductId(null);
        return productRepository.save(product);
    }


    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

}
