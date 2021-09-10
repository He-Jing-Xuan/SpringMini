/**
 * @Author tal
 * @Date 2021/9/8 11:28 上午
 * @Version 1.0
 */
public interface IUUserDao {
    String queryUserName(String uId);

    String register(String userName);
}
