package com.cagatayhan.service.Impl;

import com.cagatayhan.dao.UserDao;
import com.cagatayhan.model.User;
import com.cagatayhan.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Çağatay Han on 1.11.2016.
 *
 * Service Layer implementation which interacts with Data Access Layer
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User findUserById(ObjectId objectId) {
        return userDao.getUserById(objectId);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(ObjectId objectId) {
        userDao.deleteUser(objectId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
