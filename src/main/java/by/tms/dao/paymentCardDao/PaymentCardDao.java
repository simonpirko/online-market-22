package by.tms.dao.paymentCardDao;

import by.tms.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PaymentCardDao extends Dao<CardPayment, Long> {
    private final static String FIND_ALL = "FROM CardPayment";
    private final static String DELETE_BY_ID = "DELETE FROM CardPayment cp WHERE cp.id = :id";

    private final SessionFactory sessionFactory;

    public PaymentCardDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CardPayment save(CardPayment card) {
        Session session = sessionFactory.openSession();
        session.save(card);
        session.close();
        return card;
    }

    @Override
    public Optional<CardPayment> findById(Long id) {

        Session session = sessionFactory.openSession();
        CardPayment card = session.get(CardPayment.class, id);
        session.close();
        return card != null ? Optional.of(card) : Optional.empty();
    }

    @Override
    public List<CardPayment> findAll() {
        Session session = sessionFactory.openSession();
        List<CardPayment> cardList = session
                .createQuery(FIND_ALL, CardPayment.class)
                .getResultList();

        return cardList;
    }

    @Override
    public void remove(CardPayment card) {
        Session session = sessionFactory.openSession();
        session.remove(card);
        session.close();
    }

    @Override
    public void removeById(Long id) {

        Session session = sessionFactory.openSession();
        session
                .createQuery(DELETE_BY_ID. CardPayment.class)
                .setParameter("id", id)
                .executeUpdate();
        session.close();
    }
    @Override
    public void update(CardPayment card) {
        Session session = sessionFactory.openSession();
        session.update(card);
        session.close();
    }
}
