//package by.tms.dao;
//
///*
//    @author Ilya Moiseenko on 22.11.23
//*/
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public abstract class AbstractDao<T, ID> implements CrudOperation<T, ID> {
//
//    private final SessionFactory sessionFactory;
//
//    public AbstractDao(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//
//    @Override
//    public T save(T entity) {
//        Session currentSession = sessionFactory.openSession();
//        currentSession.save(entity);
//        currentSession.close();
//
//        return entity;
//    }
//
//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<T> findById(Long id) {
//        Session currentSession = sessionFactory.openSession();
//        T entity = currentSession.get(, id);
//        currentSession.close();
//
//        return Optional.of(entity);
//    }
//
//
//    @Override
//    public List<T> findAll(){
//        Session currentSession = sessionFactory.openSession();
//        List<T> entityList = new ArrayList<>();
//
//
//        return entityList;
//
//    }
//
//    @Override
//    public void remove(T entity) {
//        Session currentSession = sessionFactory.openSession();
//        currentSession.remove(entity);
//        currentSession.close();
//    }
//
//
//    @Override           //?????????????????????
//    public void removeById(Long id, Class<T> clazz) {
//        Session currentSession = sessionFactory.openSession();
//        currentSession.remove(id);
//        currentSession.close();
//    }
//
//    @Override
//    public void update(T updated) {
//        Session currentSession = sessionFactory.openSession();
//        currentSession.update(updated);
//        currentSession.close();
//    }
//}
