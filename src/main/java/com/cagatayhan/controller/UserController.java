package com.cagatayhan.controller;

import com.cagatayhan.model.User;
import com.cagatayhan.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Çağatay Han on 1.11.2016.
 *
 * Single Page controller class which handles AJAX requests
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getAll")
    @ResponseBody
    public List<User> showUsersTest() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") ObjectId objectId) {
        return userService.findUserById(objectId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "usermanagement";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") ObjectId objectId) {
        userService.deleteUser(objectId);
        return "usermanagement";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public @ResponseBody User updateUserTest(@PathVariable("id") ObjectId objectId, @RequestBody User user) {
        user.setId(objectId);
        userService.updateUser(user);
        return user;
    }
}
