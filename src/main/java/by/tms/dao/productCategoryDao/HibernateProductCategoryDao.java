package by.tms.dao.productCategoryDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.dao.CrudOperation;
import by.tms.entity.ProductCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class HibernateProductCategoryDao implements CrudOperation<ProductCategory> {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateProductCategoryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(ProductCategory productCategory) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(productCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductCategory> findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ProductCategory productCategory = currentSession.get(ProductCategory.class, id);

        return Optional.of(productCategory);
    }

    @Override
    public void remove(ProductCategory productCategory) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.remove(productCategory);
    }

    @Override
    public void update(ProductCategory updated) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(updated);
    }
}
