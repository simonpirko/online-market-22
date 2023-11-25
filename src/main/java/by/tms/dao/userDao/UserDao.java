
package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;


@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }
    @Transactional
    public User findById (Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class,id);
        session.close();
        return user;
    }

    public void remove(User user) {
        Session session = sessionFactory.openSession();
        session.remove(user);
        session.close();
    }


}



