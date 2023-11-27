package by.tms.dao.reviewDao;

import by.tms.dao.Dao;
import by.tms.dao.ShopDao.ShopDao;
import by.tms.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ReviewDao implements Dao<Review, Long> {
    private final static String FIND_ALL = "SELECT ur FROM tb_user_review ur";
    private final static String DELETE_BY_ID = "DELETE FROM tb_user_review ur WHERE ur.id = :id";
    private final static String FIND_BY_USER_ID = "SELECT ur FROM tb_user_review ur WHERE ur.user_id = :user_id";
    private final static String FIND_BY_SHOP_ID = "SELECT ur FROM tb_user_review ur WHERE ur.shop_id = :shop_id";
    private final static String FIND_BY_SHOP_ORDER_ID = "SELECT ur FROM tb_user_review ur WHERE ur.shop_order_id = :shop_order_id";
    private final SessionFactory sessionFactory;

    public ReviewDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Review save(Review review) {
        Session session = sessionFactory.openSession();
        session.save(review);
        session.close();

        return review;
    }

    @Override
    public Optional<Review> findById(Long id) {
        Session session = sessionFactory.openSession();
        Review review = session.get(Review.class, id);
        session.close();

        return review != null ? Optional.of(review) : Optional.empty();
    }

    @Override
    public List<Review> findAll() {
        Session session = sessionFactory.openSession();
        List<Review> reviewList = session
                .createQuery(FIND_ALL, Review.class)
                .getResultList();
        session.close();

        return reviewList;
    }

    @Override
    public void remove(Review review) {
        Session session = sessionFactory.openSession();
        session.remove(review);
        session.close();
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session.createQuery(DELETE_BY_ID, Review.class)
                .setParameter("id", id)
                .executeUpdate();
        session.close();
    }

    @Override
    public void update(Review review) {
        Session session = sessionFactory.openSession();
        session.update(review);
    }

    public List<Review> findByUserId(Long id) {
        Session session = sessionFactory.openSession();
        List<Review> reviewList = session
                .createQuery(FIND_BY_USER_ID, Review.class)
                .setParameter("user_id", id)
                .getResultList();
        session.close();

        return reviewList;
    }

    public List<Review> findByShopId(Long id) {
        Session session = sessionFactory.openSession();
        List<Review> reviewList = session
                .createQuery(FIND_BY_SHOP_ID, Review.class)
                .setParameter("shop_id", id)
                .getResultList();
        session.close();

        return reviewList;
    }

    public List<Review> findByShopOrderId(Long id) {
        Session session = sessionFactory.openSession();
        List<Review> reviewList = session
                .createQuery(FIND_BY_SHOP_ORDER_ID, Review.class)
                .setParameter("shop_order_id", id)
                .getResultList();
        session.close();

        return reviewList;
    }
}
