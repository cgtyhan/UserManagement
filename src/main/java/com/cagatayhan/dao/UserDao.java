package com.cagatayhan.dao;

import com.cagatayhan.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Çağatay Han on 1.11.2016.
 *
 * Data Access Inteface
 */
public interface UserDao{
    User getUserById(ObjectId objectId);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(ObjectId objectId);
}
