package con.he.SpringMini.aop;

/**
 * @Author tal
 * @Date 2021/9/9 10:54 上午
 * @Version 1.0
 */
public interface ClassFilter {
    /**
     * 找到节点给定的接口和目标类
     * @param clazz
     * @return
     */
    boolean matcher(Class<?> clazz);
}
