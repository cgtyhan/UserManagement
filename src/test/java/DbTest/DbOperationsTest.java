package DbTest;

import com.cagatayhan.model.User;
import com.cagatayhan.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Çağatay Han on 6.11.2016.
 *
 * DB Operations Test Class
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/resources/applicationContextTest.xml")
public class DbOperationsTest {

    @Autowired
    UserService userService;

    @Test
    public void getAllUsers() {
        try {
            userService.getAllUsers();
            Assert.assertTrue("Getting all users operation is OK", true);
        }
        catch (Throwable ex) {
            Assert.fail();
        }
    }

    @Test
    public void insertUserTest(){
        User user = new User("Çağatay", "Han", "5302002731");

        try {
            userService.addUser(user);
            Assert.assertTrue("Insert operation is OK", true);
        }
        catch (Throwable ex) {
            Assert.fail();
        }
    }

    @Test
    public void updateUserTest() {
        List<User> userList = userService.getAllUsers();
        User user = userList.get(0);
        System.out.println(user.getId());
        user.setName("Serhan");

        try {
            userService.updateUser(user);
            Assert.assertEquals(userList.get(0).getName(), "Serhan");
        }
        catch (Throwable ex) {
            Assert.fail();
        }
    }

    @Test
    public void deleteUserTest() {
        List<User> userList = userService.getAllUsers();
        User user = userList.get(0);

        try {
            userService.deleteUser(user.getId());
            Assert.assertTrue(true);
        }
        catch (Throwable ex) {
            Assert.fail();
        }
    }
}
