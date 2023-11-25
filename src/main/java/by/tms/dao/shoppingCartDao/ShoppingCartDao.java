package by.tms.dao.shoppingCartDao;

import by.tms.dao.Dao;
import by.tms.entity.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ShoppingCartDao implements Dao<ShoppingCart, Long> {
    private final static String FIND_ALL = "SELECT FROM tb_shopping_cart shc";       //???????????????
    private final static String DELETE_BY_ID = "DELETE FROM tb_shopping_cart shc WHERE shc.id = :id";

    private final SessionFactory sessionFactory;

    public ShoppingCartDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        Session session = sessionFactory.openSession();
        session.save(shoppingCart);
        session.close();

        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) {       //?????????????????????????
        Session session = sessionFactory.openSession();
        ShoppingCart shoppingCart = session.get(ShoppingCart.class, id);
        session.close();

        if (shoppingCart != null) {
            return Optional.of(shoppingCart);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public List<ShoppingCart> findAll() {
        List<ShoppingCart> shoppingCartsList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session
                .createQuery(FIND_ALL, ShoppingCart.class)
                .getResultList();
        session.close();

        return shoppingCartsList;

    }

    @Override
    public void remove(ShoppingCart shoppingCart) {
        Session session = sessionFactory.openSession();
        session.remove(shoppingCart);
        session.close();
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session
                .createQuery(DELETE_BY_ID, ShoppingCart.class)
                .setParameter("id", id)
                .executeUpdate();
        session.close();
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Session session = sessionFactory.openSession();
        session.update(shoppingCart);
        session.close();
    }
}

