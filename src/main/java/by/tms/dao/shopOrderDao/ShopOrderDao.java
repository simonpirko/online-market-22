package by.tms.dao.shopOrderDao;

import by.tms.dao.Dao;
import by.tms.entity.Shop;
import by.tms.entity.ShopOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopOrderDao implements Dao<ShopOrder, Long> {

    private final static String FIND_ALL = "SELECT s FROM tb_shop_order s";
    private final static String DELETE_BY_ID = "DELETE FROM tb_shop_order s WHERE s.id = :id";
    private final SessionFactory sessionFactory;

    public ShopOrderDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ShopOrder save(ShopOrder shopOrder) {
        Session session = sessionFactory.openSession();
        session.save(shopOrder);
        session.close();

        return shopOrder;
    }

    @Override
    public Optional<ShopOrder> findById(Long id) {
        Session session = sessionFactory.openSession();
        ShopOrder shopOrder = session.get(ShopOrder.class, id);
        session.close();

        if (shopOrder != null) {
            return Optional.of(shopOrder);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public List<ShopOrder> findAll() {
        List<ShopOrder> shopOrdersList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session
                .createQuery(FIND_ALL, ShopOrder.class)
                .getResultList();
        session.close();

        return shopOrdersList;
    }

    @Override
    public void remove(ShopOrder shopOrder) {
        Session session = sessionFactory.openSession();
        session.remove(shopOrder);
        session.close();
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session
                .createQuery(DELETE_BY_ID, ShopOrder.class)
                .setParameter("id", id)
                .executeUpdate();
        session.close();
    }

    @Override
    public void update(ShopOrder shopOrder) {
        Session session = sessionFactory.openSession();
        session.update(shopOrder);
    }
}
