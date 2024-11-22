package ru.javamentor.crudapplication.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.crudapplication.dao.UserDao;
import ru.javamentor.crudapplication.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    private UserDao userDao;

    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);

    }

    @Override
    public void deleteUser(Long id) {
        this.userDao.deleteUser(id);

    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}
