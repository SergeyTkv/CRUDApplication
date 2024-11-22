package ru.javamentor.crudapplication.dao;

import ru.javamentor.crudapplication.model.User;

import java.util.List;


public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public User getUserById(Long id);
    public List<User> getAllUsers();

}
