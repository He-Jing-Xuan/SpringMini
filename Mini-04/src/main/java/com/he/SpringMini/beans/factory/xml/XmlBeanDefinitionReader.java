package com.he.SpringMini.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.PropertyValue;
import com.he.SpringMini.beans.factory.config.BeanDefinition;
import com.he.SpringMini.beans.factory.config.BeanReference;
import com.he.SpringMini.beans.factory.support.AbstractBeanDefinitionReader;
import com.he.SpringMini.beans.factory.support.BeanDefinitionRegistry;
import com.he.SpringMini.context.annotation.ClassPathBeanDefinitionScanner;
import com.he.SpringMini.core.io.Resource;
import com.he.SpringMini.core.io.ResourceLoader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.NodeList;


import java.beans.Beans;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author tal
 * @Date 2021/9/6 4:58 下午
 * @Version 1.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeanException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException | DocumentException e) {
            throw new BeanException("IOException parsing XML document from " + resource, e);
        }

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeanException {
        for (Resource resource : resources){
            loadBeanDefinitions(resources);
        }

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeanException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String[] location) throws BeanException {
        for (String l : location){
            loadBeanDefinitions(l);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(inputStream);
        Element root = doc.getRootElement();

        Element compontScan = root.element("component-scan");
        if(compontScan != null){
            String scanPath = compontScan.attributeValue("base-package");
            if(StrUtil.isEmpty(scanPath)){
                throw new BeanException("The value of base-package attribute can not be empty or null");
            }
            scanPackage(scanPath);
        }
        List<Element> beanList = root.elements("bean");
        for(Element bean : beanList){
            String id = bean.attributeValue("id");
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");
            String initMethod = bean.attributeValue("init-method");
            String destroyMethodName = bean.attributeValue("destroy-method");
            String beanScope = bean.attributeValue("scope");

            // 获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestoryMethodName(destroyMethodName);

            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }

            List<Element> propertyList = bean.elements("property");
            // 读取属性并填充
            for (Element property : propertyList) {
                // 解析标签：property
                String attrName = property.attributeValue("name");
                String attrValue = property.attributeValue("value");
                String attrRef = property.attributeValue("ref");
                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeanException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }

    }
    private void scanPackage(String scanPath){
        String [] basePackages = StrUtil.splitToArray(scanPath,',');
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(getRegistry());
        scanner.doScan(basePackages);
    }
}
