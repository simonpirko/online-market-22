package by.tms.dao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class AbstractDao<T> implements CrudOperation<T> {

    private final SessionFactory sessionFactory;

    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(T entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(Long id, Class<T> clazz) {
        Session currentSession = sessionFactory.getCurrentSession();
        T entity = currentSession.get(clazz, id);

        return Optional.of(entity);
    }

    @Override
    public void remove(T entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.remove(entity);
    }

    @Override
    public void update(T updated) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(updated);
    }
}
