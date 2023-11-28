package by.tms.dao.promotionDao;

import by.tms.dao.AbstractDao;
import by.tms.entity.Promotion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernatePromotionDao extends AbstractDao<Promotion> {
    @Autowired
    public HibernatePromotionDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
