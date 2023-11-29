package by.tms.service;

import by.tms.dao.reviewDao.ReviewDao;
import by.tms.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService {
    private final ReviewDao reviewDao;
    @Autowired
    public ReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public Review save(Review review) {
        return reviewDao.save(review);
    }

    @Transactional(readOnly = true)
    public Optional<Review> findById(Long id) {
        return reviewDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    public void remove(Review review) {
        reviewDao.remove(review);
    }

    public void removeById(Long id) {
        reviewDao.removeById(id);
    }

    public void update(Review review) {
        reviewDao.update(review);
    }

    @Transactional(readOnly = true)
    public List<Review> findByUserId(Long id) {
        return reviewDao.findByUserId(id);
    }

    @Transactional(readOnly = true)
    public List<Review> findByShopId(Long id) {
        return reviewDao.findByShopId(id);
    }

    @Transactional(readOnly = true)
    public List<Review> findByShopOrderId(Long id) {
        return reviewDao.findByShopOrderId(id);
    }


}
