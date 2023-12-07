
package by.tms.dao.userDao;

import by.tms.dao.Dao;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


@Repository
@Transactional
public class UserDao implements Dao<User, Long> {
    private final static String FIND_ALL = "FROM User";
    private final static String DELETE_BY_ID = "DELETE  FROM User u WHERE u.id =:id";
    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        if (user != null) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session
                .createQuery(FIND_ALL, User.class)
                .getResultList();
        session.close();

        return userList;
    }


    @Override
    public void remove(User user) {
        Session session = sessionFactory.openSession();
        session.remove(user);
        session.close();
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session
                .createQuery(DELETE_BY_ID, User.class)
                .setParameter("id", id)
                .executeUpdate();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.update(user);
        session.close();
    }

    public Optional<User> findByUsername(String username) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, username);
        session.close();

        if (user != null) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

}



