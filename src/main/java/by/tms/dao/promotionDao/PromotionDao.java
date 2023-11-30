package by.tms.dao.promotionDao;

import by.tms.dao.Dao;
import by.tms.entity.Promotion;
import by.tms.entity.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PromotionDao implements Dao<Promotion, Long> {
    private final static String FIND_ALL = "SELECT pro FROM tb_promotion pro";
    private final static String DELETE_BY_ID = "DELETE FROM tb_promotion pro WHERE pro.id = :id";

    private final SessionFactory sessionFactory;

    public PromotionDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Promotion save(Promotion promotion) {
        Session session = sessionFactory.openSession();
        session.save(promotion);
        session.close();
        return promotion;
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        Session session = sessionFactory.openSession();
        Promotion promotion = session.get(Promotion.class, id);
        session.close();

        if (promotion != null) {
            return Optional.of(promotion);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Promotion> findAll() {
        List<Promotion> promotionList = new ArrayList<>();
       Session session = sessionFactory.openSession();

        session.createQuery(FIND_ALL, Promotion.class)
               .getResultList();
       session.close();

       return promotionList;
    }

    @Override
    public void remove(Promotion promotion) {
        Session session = sessionFactory.openSession();
        session.remove(promotion);
        session.close();
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session.createQuery(DELETE_BY_ID, Shop.class)
               .setParameter("id", id)
               .executeUpdate();
        session.close();
    }

    @Override
    public void update(Promotion promotion) {
        Session session = sessionFactory.openSession();
        session.update(promotion);
    }
}
