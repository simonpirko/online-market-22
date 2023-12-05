package by.tms.services;

import by.tms.configuration.principalEntity.UserPrincipal;
import by.tms.dao.userDao.UserDao;
import by.tms.entity.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        User user = userDao.findByEmailAddress(emailAddress).orElseThrow();
        return UserPrincipal.builder()
                .emailAddress(user.getEmailAddress())
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
}





