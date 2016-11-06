package com.cagatayhan.service;

import com.cagatayhan.model.User;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by Çağatay Han on 1.11.2016.
 *
 * Service Layer Interface
 */
public interface UserService {
    User findUserById(ObjectId objectId);
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(ObjectId objectId);
    void updateUser(User user);
}
