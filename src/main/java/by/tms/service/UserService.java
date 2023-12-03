package by.tms.service;

import by.tms.dao.userDao.UserDao;
import by.tms.entity.Role;
import by.tms.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public User save(User user) {
        return userDao.save(user);
    }


    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        if (id < 1) {
            throw new NoSuchElementException("User not found");
        }
        return userDao.findById(id);
    }


    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }


    public void remove(User user) {
        userDao.remove(user);
    }


    public void removeById(Long id) {
        if (id < 1) {
            throw new NoSuchElementException("User not found");
        }
        userDao.removeById(id);
    }

    public void update(User user) {
        userDao.update(user);
    }


    @Transactional(readOnly = true)
    public Optional<User> findByPhone(String phoneNumber) {
        return userDao.findByPhone(phoneNumber);
    }


    @Transactional(readOnly = true)
    public void assignRoleToUser(User user, List<Role> roles){
        userDao.assignRoleToUser(user, roles);
    }
}





