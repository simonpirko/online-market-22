package by.tms.service;


import by.tms.dao.shopOrderDao.ShopOrderDao;
import by.tms.entity.ShopOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShopOrderService {
    private final ShopOrderDao shopOrderDao;

    public ShopOrderService(ShopOrderDao shopOrderDao) {
        this.shopOrderDao = shopOrderDao;
    }

    public ShopOrder save(ShopOrder shopOrder) {
        return shopOrderDao.save(shopOrder);
    }


    @Transactional(readOnly = true)
    public Optional<ShopOrder> findById(Long id) {
        return shopOrderDao.findById(id);
    }


    @Transactional(readOnly = true)
    public List<ShopOrder> findAll() {
        return shopOrderDao.findAll();
    }


    public void remove(ShopOrder shopOrder) {
        shopOrderDao.remove(shopOrder);
    }


    public void removeById(Long id) {
        shopOrderDao.removeById(id);
    }


    public void update(ShopOrder shopOrder) {
        shopOrderDao.update(shopOrder);
    }

}
