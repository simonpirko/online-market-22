package by.tms.dao.productCategoryDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.entity.ProductCategory;

import java.util.Optional;

public interface ProductCategoryDao {

    void save(ProductCategory productCategory);
    Optional<ProductCategory> findById(Long id);
    void remove(ProductCategory productCategory);
    void update(ProductCategory updated);
}
