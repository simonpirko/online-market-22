package by.tms.dao.ShopDao;

import by.tms.dao.Dao;
import by.tms.entity.Shop;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopDao implements Dao<Shop, Long> {

    private final static String FIND_ALL = "SELECT s FROM tb_shop s";
    private final static String DELETE_BY_ID = "DELETE FROM tb_shop s WHERE s.id = :id";
    private final static String FIND_BY_USER_ID = "SELECT FROM tb_shop s WHERE s.user_id = :user_id";
    private final SessionFactory sessionFactory;

    public ShopDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Shop save(Shop shop) {
        Session session = sessionFactory.openSession();
        session.save(shop);
        session.close();

        return shop;
    }

    @Override
    public Optional<Shop> findById(Long id) {
        Session session = sessionFactory.openSession();
        Shop shop = session.get(Shop.class, id);
        session.close();

        if (shop != null) {
            return Optional.of(shop);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public List<Shop> findAll() {
        List<Shop> shopsList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session
                .createQuery(FIND_ALL, Shop.class)
                .getResultList();
        session.close();

        return shopsList;
    }

    @Override
    public void remove(Shop shop) {
        Session session = sessionFactory.openSession();
        session.remove(shop);
        session.close();
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session
                .createQuery(DELETE_BY_ID, Shop.class)
                .setParameter("id", id)
                .executeUpdate();
        session.close();
    }

    @Override
    public void update(Shop shop) {
        Session session = sessionFactory.openSession();
        session.update(shop);
    }


    public List<Shop> findByUserId(Long id){
        List<Shop> shopsList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session
                .createQuery(FIND_BY_USER_ID, Shop.class)
                .setParameter("user_id", id)
                .getResultList();
        session.close();

        return shopsList;
    }
}
