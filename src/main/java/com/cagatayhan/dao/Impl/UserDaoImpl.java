package com.cagatayhan.dao.Impl;

import com.cagatayhan.dao.UserDao;
import com.cagatayhan.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.BSONObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Çağatay Han on 1.11.2016.
 *
 * Data Access Class which implements the UserDao Interface, interact with DB is handled here.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User getUserById(ObjectId objectId) {
        return mongoTemplate.findById(objectId, User.class);
    }

    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public void addUser(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void updateUser(User user) {
        Update update = new Update();
        update.set("name", user.getName());
        update.set("surname", user.getSurname());
        update.set("phone", user.getPhone());
        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(user.getId())), update, User.class);
    }

    @Override
    public void deleteUser(ObjectId objectId) {
        mongoTemplate.remove(getUserById(objectId));
    }
}
