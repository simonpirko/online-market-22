package by.tms.service;

import by.tms.dao.promotionDao.PromotionDao;
import by.tms.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PromotionService {

    @Autowired
    PromotionDao promotionDao;

    public void savePromotion(Promotion promotion){
        promotionDao.save(promotion);
    }

    public Optional<Promotion> findPromotionById(Long id){
        return  promotionDao.findById(id);
    }

    public void updatePromotion(Promotion promotion){
        promotionDao.update(promotion);
    }

    public void deletePromotion(Promotion promotion){
        promotionDao.remove(promotion);
    }
}
