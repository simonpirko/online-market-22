package by.tms.services;

import by.tms.dao.UserDao;
import by.tms.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
public class UserService {


    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public User save ( User user ) {
        return userDao.save(user);
    }

    public void findById(Long id){
        if (id < 1){
            throw new NoSuchElementException("User not found");
        }
        userDao.findById(id);
    }

    public  void update (User user) {
        userDao.update(user);
    }
    public  void remove (User user){
            userDao.remove(user);
        }
     public void removeById(Long id) {
        if (id < 1){
            throw new NoSuchElementException("User not found");
        }
     }

     @Transactional(readOnly = true)
     public List< User> findAll(){
        return userDao.findById(user);
     }

    }





