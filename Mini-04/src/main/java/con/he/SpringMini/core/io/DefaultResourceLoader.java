package con.he.SpringMini.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author tal
 * @Date 2021/9/6 4:43 下午
 * @Version 1.0
 * 根据不同的 类型 进行 资源的加载
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
