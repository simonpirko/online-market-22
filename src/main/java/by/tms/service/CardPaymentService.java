package by.tms.service;

import by.tms.dao.paymentCardDao.PaymentCardDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardPaymentService {
    private final PaymentCardDao paymentCardDao;

    public CardPaymentService(PaymentCardDao paymentCardDao) {
        this.paymentCardDao = paymentCardDao;
    }
    public CardPayment save(CardPayment card){
       return paymentCardDao.save(card);
    }
    @Transactional(readOnly = true)
    public Optional<CardPayment> findById(Long id) {
        return paymentCardDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<CardPayment> findAll() {
        return paymentCardDao.findAll();
    }

    public void remove(CardPayment card) {
        paymentCardDao.remove(card);
    }

    public void removeById(Long id) {
        paymentCardDao.removeById(id);
    }

    public void update(CardPayment card) {
        paymentCardDao.update(card);
    }
}
