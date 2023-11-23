package by.tms.dao.shoppingCartDao;

import by.tms.entity.ShoppingCart;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.postgresql.core.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateShoppingCartDao implements ShoppingCartDao{
    @Override
    public boolean save(ShoppingCart value) {
        return false;
    }

    @Override
    public boolean remove(long id) {
        return false;
    }

    @Override
    public boolean remove(ShoppingCart value) {
        return false;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }

    @Override
    public ShoppingCart findById(long id) {
        return null;
    }

    @Override
    public boolean update(long id) {
        return false;
    }

    @Override
    public ShoppingCart findByUserId(long id) {
        return null;
    }
}

