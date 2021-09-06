/**
 * @Author tal
 * @Date 2021/9/6 5:16 下午
 * @Version 1.0
 */
public class UserService {
    private String uId;

    private UserDao userDao;

    public UserService(String uId, UserDao userDao) {
        this.uId = uId;
        this.userDao = userDao;
    }
    public UserService(){}
    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
