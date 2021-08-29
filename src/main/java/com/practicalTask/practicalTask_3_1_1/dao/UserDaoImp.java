package com.practicalTask.practicalTask_3_1_1.dao;

import com.practicalTask.practicalTask_3_1_1.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        return entityManager
                .createQuery("select u from User u where u.email=:email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public User getByUserName(String username) {
        return entityManager
                .createQuery("select u from User u where u.username=:username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }
}
