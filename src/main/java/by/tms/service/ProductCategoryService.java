package by.tms.service;

/*
    @author Ilya Moiseenko on 28.11.23
*/

import by.tms.dao.productCategoryDao.ProductCategoryDao;
import by.tms.entity.product.ProductCategory;
import by.tms.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryDao productCategoryDao;

    private final String NOT_FOUND_MESSAGE = "Category not found";

    public void save(ProductCategory productCategory) {
        productCategoryDao.save(productCategory);
    }

    public ProductCategory findById(Long id) {
        Optional<ProductCategory> productCategoryById = productCategoryDao.findById(id);
        if (productCategoryById.isPresent())
            return productCategoryById.get();

        throw new NotFoundException(NOT_FOUND_MESSAGE);
    }

    public void remove(ProductCategory productCategory) {
        productCategoryDao.remove(productCategory);
    }

    public void update(ProductCategory productCategory) {
        productCategoryDao.update(productCategory);
    }
}
