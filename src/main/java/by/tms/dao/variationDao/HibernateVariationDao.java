package by.tms.dao.variationDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.dao.AbstractDao;
import by.tms.entity.Variation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateVariationDao extends AbstractDao<Variation> {

    @Autowired
    public HibernateVariationDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
