package aotuwired;

import com.he.SpringMini.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/25 2:05 下午
 * @Version 1.0
 */
@Component
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小贺，北京，亦庄");
        hashMap.put("10002", "八杯水，上海，尖沙咀");
        hashMap.put("10003", "阿毛，香港，铜锣湾");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
