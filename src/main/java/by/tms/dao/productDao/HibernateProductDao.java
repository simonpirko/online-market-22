package by.tms.dao.productDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.dao.AbstractDao;
import by.tms.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateProductDao extends AbstractDao<Product> {

    @Autowired
    public HibernateProductDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
