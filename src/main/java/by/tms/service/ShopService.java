package by.tms.service;

import by.tms.dao.ShopDao.ShopDao;
import by.tms.entity.Shop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShopService {
    private final ShopDao shopDao;

    public ShopService(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    public Shop save(Shop shop) {
        return shopDao.save(shop);
    }


    @Transactional(readOnly = true)
    public Optional<Shop> findById(Long id) {
        return shopDao.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Shop> findAll() {
        return shopDao.findAll();
    }


    public void remove(Shop shop) {
        shopDao.remove(shop);
    }


    public void removeById(Long id) {
        shopDao.removeById(id);
    }


    public void update(Shop shop) {
        shopDao.update(shop);
    }


    @Transactional(readOnly = true)
    public List<Shop> findByUserId(Long id) {
        return shopDao.findByUserId(id);
    }
}

