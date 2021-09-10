package com.he.SpringMini.beans.factory;

import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.PropertyValue;
import com.he.SpringMini.beans.PropertyValues;
import com.he.SpringMini.beans.factory.config.BeanDefinition;
import com.he.SpringMini.beans.factory.config.BeanFactoryPostProcessor;
import com.he.SpringMini.beans.factory.config.ConfigurableListableBeanFactory;
import com.he.SpringMini.core.io.DefaultResourceLoader;
import com.he.SpringMini.core.io.Resource;

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
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        //加载属性文件
        try{
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            String [] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for(String beanName : beanDefinitionNames){
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for(PropertyValue propertyValue : propertyValues.getPropertyValues()){
                    Object value = propertyValue.getValue();
                    if(!(value instanceof String)) continue;;
                    String strVal = (String) value;
                    StringBuilder builder = new StringBuilder(strVal);
                    int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if(startIdx!=-1&&stopIdx!=-1&&startIdx<stopIdx){
                        String propKey = strVal.substring(startIdx+2,stopIdx);
                        String propVal = properties.getProperty(propKey);
                        builder.replace(startIdx,startIdx+1,propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(),builder.toString()));
                    }
                }
            }

        }catch (IOException e){
            throw new BeanException("Could not load properties", e);
        }

    }
    public void setLocation(String location){
        this.location = location;
    }
}
