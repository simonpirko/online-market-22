package by.tms.dao.shoppingCartDao;

import by.tms.dao.Dao;
import by.tms.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao extends Dao<ShoppingCart> {
    boolean update(long id);
    ShoppingCart findByUserId(long id);
}
