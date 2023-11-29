package by.tms.dao.promotionDao;

import by.tms.dao.Dao;
import by.tms.entity.Promotion;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PromotionDao implements Dao<Promotion, Long> {

    private final SessionFactory sessionFactory;

    public PromotionDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Promotion save(Promotion promotion) {
        return null;
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Promotion> findAll() {
        return null;
    }

    @Override
    public void remove(Promotion promotion) {
    }

    @Override
    public void removeById(Long id) {
    }

    @Override
    public void update(Promotion promotion) {
    }
}
