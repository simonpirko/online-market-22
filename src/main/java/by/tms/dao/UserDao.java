package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;




public class UserDao  implements Dao<User,Long> {
    private final static String FIND_ALL = "SELECT s FROM tb_user s";
    private final static String DELETE_BY_ID = "DELETE  FROM tb_user s WHERE s.id =:id";
    private final SessionFactory sessionFactory;

    public UserDao( SessionFactory sessionFactory){
        this.sessionFactory =sessionFactory;
    }
    @Override
    public User save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
        return  user;
    }

    public User findById (Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class,id);
        session.close();
        if(user != null) {
            return user;
        }else {
            System.out.println("User not found");
        }
        return null;
    }

    @Override
    public List< User> findAll(){
        List<User>userList = new ArrayList<>();
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
    public void removeById(Long id){
        Session session = sessionFactory.openSession();
        session
                .createQuery(DELETE_BY_ID, User.class)
                .setParameter("id",id)
                .executeUpdate();
        session.close();
    }

    @Override
    public void update(User entity) {
        Session session = sessionFactory.openSession();
        session.update(user);
        session.close();
    }


}
