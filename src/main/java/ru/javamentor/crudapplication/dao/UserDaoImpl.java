package ru.javamentor.crudapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.crudapplication.model.User;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class.getName());


    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
        logger.info("User inserted successfully. User: " + user);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
        logger.info("User updated successfully. User: " + user);

    }

    @Override
    @Transactional
    public void deleteUser(Long id) {

        User user = (User) entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
            logger.info("User deleted successfully. User: " + user);
        }
        logger.info("User removed no successfully. User: " + user);


    }

    @Override
    public User getUserById(Long id) {

        logger.info("User found successfully. User: ");
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }


}
