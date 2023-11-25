package by.tms.dao.productDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/


import by.tms.dao.Dao;
import by.tms.entity.Product;
import com.sun.xml.bind.v2.model.core.ID;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductDao implements Dao<Product, Long> {

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(Product product) {

    }
}
