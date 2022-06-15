package zsx.dao;


import zsx.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao  {
    public User getUserById(@Param("id") int id);

    public List<User> getUserByAge(@Param("age") int age);
}
