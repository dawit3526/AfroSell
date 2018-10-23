package com.eri.afrosell.controller;
import com.eri.afrosell.exceptions.ApplicationException;
import com.eri.afrosell.model.Category;
import com.eri.afrosell.model.Product;
import com.eri.afrosell.model.ProductCategory;
import com.eri.afrosell.repositories.CategoryRepository;
import com.eri.afrosell.repositories.ProductCategoryRepository;
import com.eri.afrosell.response.APIResponse;
import com.eri.afrosell.response.util.APIStatus;
import com.eri.afrosell.response.util.ResponseUtil;
import com.eri.afrosell.service.product.ProductServiceImpl;
import com.eri.afrosell.util.Constant;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(APINames.PRODUCTS)
public class ProductController {


    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    protected ResponseUtil responseUtil;
    @ApiOperation(value = "get product by company id", notes = "")
    @RequestMapping(method = RequestMethod.GET,produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> getAllProducts(
            @PathVariable long company_id,
            @RequestParam(required = false, defaultValue = Constant.DEFAULT_PAGE_NUMBER) Integer pageNumber,
            @RequestParam(required = false, defaultValue = Constant.DEFAULT_PAGE_SIZE) Integer pageSize) {
        //Integer company_Id = 1;
        logger.info("company Id " + company_id);
        Page<Product> products = productService.getByCompanyId(company_id, pageNumber, pageSize);

//       statusResponse = new StatusResponse(APIStatus.OK.getCode(), products.getContent(), products.getTotalElements());
        return responseUtil.successResponse(products.getContent());
    }

    @ApiOperation(value = "get products by product id", notes = "")
    @RequestMapping(path = APINames.PRODUCT_BY_ID, method = RequestMethod.GET, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> getProductById(HttpServletRequest request,
                                                      @PathVariable Long product_id,
                                                      @PathVariable Long company_id) {
        System.out.println("id company : " + company_id.toString());
        // get product
        Product p = productService.getProductById(company_id, product_id);
        logger.info("product " + p.getName() );
        if (p != null) {
            // get all attributes of product
//        ProductAttributeDetail pad = productAttributeService.findByProductIdAndAttributeId(product_Id, Constant.PRODUCT_ATTRIBUTE.DETAIL_IMAGES.getId());
            List<ProductCategory> listProductCate = productCategoryRepository.getProCateByProductId(product_id);
            List<Map<String, Object>> listCate = new ArrayList<Map<String, Object>>();
            for (ProductCategory result : listProductCate) {
                Map<String, Object> category = new HashMap();
                //find category name with categoryId
                Category cate = categoryRepository.findByCategoryId(result.getId().getCategoryId());
                logger.info("desc " + cate.getDescription());
                if (cate != null) {
                    category.put("text", cate.getName());
                    category.put("id", cate.getCategoryId());
                }
                //add category name to list String
                listCate.add(category);
            }
            Map<String, Object> result = new HashMap();
            result.put("product", p);
            result.put("list_category", listCate);

            return responseUtil.successResponse(result);
        } else {
            throw new ApplicationException(APIStatus.GET_PRODUCT_ERROR);
        }
    }


    @ApiOperation(value = "get list product by product ids", notes = "")
    @RequestMapping(path = APINames.PRODUCT_BY_IDS, method = RequestMethod.POST, produces = APINames.CHARSET)
    public ResponseEntity<APIResponse> getListProductByIds(
            @PathVariable Long company_id,
            @RequestBody List<Long> productIds) {

        if (productIds != null && !productIds.isEmpty()) {
            List<Product> products = (List<Product>) productService.getProductsById(company_id, productIds);
            if (products != null) {
//                statusResponse = new StatusResponse(APIStatus.OK.getCode(), products, products.size());
                return responseUtil.successResponse(products);
            } else {
                throw new ApplicationException(APIStatus.INVALID_PARAMETER);
            }
        } else {
            throw new ApplicationException(APIStatus.INVALID_PARAMETER);
        }

//        return writeObjectToJson(statusResponse);
    }


}
