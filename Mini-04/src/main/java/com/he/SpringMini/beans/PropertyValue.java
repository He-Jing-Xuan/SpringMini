package com.he.SpringMini.beans;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/5 4:43 下午
 * @Version 1.0
 * 属性值
 */
public class PropertyValue {
    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
