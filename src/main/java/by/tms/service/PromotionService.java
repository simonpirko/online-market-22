package by.tms.service;

import by.tms.dao.promotionDao.HibernatePromotionDao;
import by.tms.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    HibernatePromotionDao promotionDao;

    public void savePromotion(Promotion promotion){
        promotionDao.save(promotion);
    }

    public Optional<Promotion> findPromotionById(Long id){
        return  promotionDao.findById(id, Promotion.class);
    }

    public void updatePromotion(Promotion promotion){
        promotionDao.update(promotion);
    }

    public void deletePromotion(Promotion promotion){
        promotionDao.remove(promotion);
    }
}
