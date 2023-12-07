package by.tms.service;

import by.tms.configuration.principalEntity.UserPrincipal;
import by.tms.dao.userDao.UserDao;
import by.tms.entity.Role;
import by.tms.entity.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username).orElseThrow();
        return UserPrincipal.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public User save(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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
    public Optional<User> findByUsername(String username) {return userDao.findByUsername(username);}


    @Transactional(readOnly = true)
    public void assignRoleToUser(User user, Role role){
        userDao.assignRoleToUser(user, role);
    }
}



