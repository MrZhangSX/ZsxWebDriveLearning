package zsx.service;

import zsx.dao.UserDao;
import zsx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public List<User> getUserByAge(int age){
        return userDao.getUserByAge(age);
    }

}
