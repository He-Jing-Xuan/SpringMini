package aotuwired;


import com.he.SpringMini.beans.factory.annotation.Autowired;
import com.he.SpringMini.beans.factory.annotation.Value;
import com.he.SpringMini.stereotype.Component;

import java.util.Random;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/25 2:05 下午
 * @Version 1.0
 */
@Component("userService")
public class UserService implements IUserService{
    @Value("${token}")
    private String token;
    @Autowired
    private UserDao userDao;
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10001") + "，" + token;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }
}
