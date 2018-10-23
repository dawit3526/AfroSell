package com.eri.afrosell.repositories;
import com.eri.afrosell.model.ProductCategory;
import com.eri.afrosell.model.ProductCategoryId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, ProductCategoryId> {

    //todo
    Iterable<ProductCategory> findById(ProductCategoryId productId);

    @Query("SELECT p FROM ProductCategory p WHERE p.id.productId = :productId")
    List<ProductCategory> getProCateByProductId(@Param("productId") Long productId);
}
