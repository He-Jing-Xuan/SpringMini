/**
 * @Author he-jing-xuan
 * @Date 2021/9/5 4:22 下午
 * @Version 1.0
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("").append(name);
        return sb.toString();
    }
}
