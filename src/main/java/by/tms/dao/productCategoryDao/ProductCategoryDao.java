package by.tms.dao.productCategoryDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.dao.Dao;
import by.tms.entity.catalogProduct.ProductCategory;
import com.sun.xml.bind.v2.model.core.ID;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductCategoryDao implements Dao<ProductCategory, Long> {
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return null;
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProductCategory> findAll() {
        return null;
    }

    @Override
    public void remove(ProductCategory productCategory) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(ProductCategory productCategory) {

    }
}
