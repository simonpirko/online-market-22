package by.tms.dao.variationOptionDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.dao.AbstractDao;
import by.tms.entity.VariationOption;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateVariationOptionDao extends AbstractDao<VariationOption> {

    @Autowired
    public HibernateVariationOptionDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
