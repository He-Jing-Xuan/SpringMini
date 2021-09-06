package con.he.SpringMini.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author tal
 * @Date 2021/9/6 4:31 下午
 * @Version 1.0
 *  资源的加载与定义的接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
