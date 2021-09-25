package com.he.SpringMini.beans.factory;

import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.PropertyValue;
import com.he.SpringMini.beans.PropertyValues;
import com.he.SpringMini.beans.factory.config.BeanDefinition;
import com.he.SpringMini.beans.factory.config.BeanFactoryPostProcessor;
import com.he.SpringMini.beans.factory.config.ConfigurableListableBeanFactory;
import com.he.SpringMini.core.io.DefaultResourceLoader;
import com.he.SpringMini.core.io.Resource;
import com.he.SpringMini.util.StringValueResolver;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/10 10:33 上午
 * @Version 1.0
 * 处理占位符配置
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    /**
     * Default placeholder prefix: {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    /**
     * Default placeholder suffix: {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    //在bean实例化之前，改变属性信息
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        //加载属性文件
        try{
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            String [] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            // ... 占位符替换属性值、设置属性值
            for(String beanName : beanDefinitionNames){
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for(PropertyValue propertyValue : propertyValues.getPropertyValues()){
                   Object value = propertyValue.getValue();
                   if(!(value instanceof String)) continue;
                   value = resolvePlaceholder((String) value,properties);
                   propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(),value));
                }
            }

            // 向容器中添加字符串解析器，供解析@Value注解使用
            StringValueResolver valueResolver = new PlaceholderResolvingStringValueResolver(properties);
            //写入属性值
            beanFactory.addEmbeddedValueResolver(valueResolver);
        }catch (IOException e){
            throw new BeanException("Could not load properties", e);
        }
    }
    
    public void setLocation(String location){
        this.location = location;
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver{

        private final Properties properties;

        public PlaceholderResolvingStringValueResolver(Properties properties){
            this.properties = properties;
        }
        @Override
        public String resolveStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }
    private String resolvePlaceholder(String value, Properties properties) {
        String strVal = value;
        StringBuilder buffer = new StringBuilder(strVal);
        int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
        int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
        if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
            String propKey = strVal.substring(startIdx + 2, stopIdx);
            String propVal = properties.getProperty(propKey);
            buffer.replace(startIdx, stopIdx + 1, propVal);
        }
        return buffer.toString();
    }
}
