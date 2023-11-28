package by.tms.service;

import by.tms.dao.shoppingCartDao.ShoppingCartDao;
import by.tms.entity.ShoppingCart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;

    public ShoppingCartService(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartDao.save(shoppingCart);
    }


    @Transactional(readOnly = true)
    public Optional<ShoppingCart> findById(Long id) {
        return shoppingCartDao.findById(id);
    }


    @Transactional(readOnly = true)
    public List<ShoppingCart> findAll() {
        return shoppingCartDao.findAll();
    }


    public void remove(ShoppingCart shoppingCart) {
        shoppingCartDao.remove(shoppingCart);
    }


    public void removeById(Long id) {
        shoppingCartDao.removeById(id);
    }


    public void update(ShoppingCart shoppingCart) {
        shoppingCartDao.update(shoppingCart);
    }

}
