import java.util.Random;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 8:50 下午
 * @Version 1.0
 */
public class User implements IUUserDao{

    @Override
    public String queryUserName(String uId) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳";
    }
    public String register(String userName){
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }
}
