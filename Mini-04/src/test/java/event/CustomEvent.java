package event;

import com.he.SpringMini.context.event.ApplicationContextEvent;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/25 10:39 上午
 * @Version 1.0
 */
// 自定义一个事件
public class CustomEvent extends ApplicationContextEvent {
    private int id;
    private String message;

    public CustomEvent(Object source, int id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
