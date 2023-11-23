package by.tms.dao.productCategoryDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.dao.AbstractDao;
import by.tms.entity.ProductCategory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateProductCategoryDao extends AbstractDao<ProductCategory> {

    @Autowired
    public HibernateProductCategoryDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
