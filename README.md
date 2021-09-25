# SpringMini
简单实现spring框架。
1实现了bean的定义，注册，获取。
2.基于Cglib实现含构造函数的构造。
3.为Bean对象注入属性和依赖。
4.实现xml解析与注册。
5.实现Application，自动识别，资源加载，扩展机制。
SpringMini
└── src
├── main
│   └── java
│       └── com.he.SpringMini
│           ├── aop
│           │   ├── aspectj
│           │   │   └── AspectJExpressionPointcut.java
│           │   │   └── AspectJExpressionPointcutAdvisor.java
│           │   ├── framework
│           │   │   ├── adapter
│           │   │   │   └── MethodBeforeAdviceInterceptor.java
│           │   │   ├── autoproxy
│           │   │   │   └── MethodBeforeAdviceInterceptor.java
│           │   │   ├── AopProxy.java
│           │   │   ├── Cglib2AopProxy.java
│           │   │   ├── JdkDynamicAopProxy.java
│           │   │   ├── ProxyFactory.java
│           │   │   └── ReflectiveMethodInvocation.java
│           │   ├── AdvisedSupport.java
│           │   ├── Advisor.java
│           │   ├── BeforeAdvice.java
│           │   ├── ClassFilter.java
│           │   ├── MethodBeforeAdvice.java
│           │   ├── MethodMatcher.java
│           │   ├── Pointcut.java
│           │   ├── PointcutAdvisor.java
│           │   └── TargetSource.java
│           ├── beans
│           │   ├── factory  
│           │   │   ├── annotation
│           │   │   │   ├── Autowired.java
│           │   │   │   ├── AutowiredAnnotationBeanPostProcessor.java
│           │   │   │   ├── Qualifier.java
│           │   │   │   └── Value.java
│           │   │   ├── config
│           │   │   │   ├── AutowireCapableBeanFactory.java
│           │   │   │   ├── BeanDefinition.java
│           │   │   │   ├── BeanFactoryPostProcessor.java
│           │   │   │   ├── BeanPostProcessor.java
│           │   │   │   ├── BeanReference.java
│           │   │   │   ├── ConfigurableBeanFactory.java
│           │   │   │   ├── InstantiationAwareBeanPostProcessor.java
│           │   │   │   └── SingletonBeanRegistry.java
│           │   │   ├── support
│           │   │   │   ├── AbstractAutowireCapableBeanFactory.java
│           │   │   │   ├── AbstractBeanDefinitionReader.java
│           │   │   │   ├── AbstractBeanFactory.java
│           │   │   │   ├── BeanDefinitionReader.java
│           │   │   │   ├── BeanDefinitionRegistry.java
│           │   │   │   ├── CglibSubclassingInstantiationStrategy.java
│           │   │   │   ├── DefaultListableBeanFactory.java
│           │   │   │   ├── DefaultSingletonBeanRegistry.java
│           │   │   │   ├── DisposableBeanAdapter.java
│           │   │   │   ├── FactoryBeanRegistrySupport.java
│           │   │   │   ├── InstantiationStrategy.java
│           │   │   │   └── SimpleInstantiationStrategy.java  
│           │   │   ├── support
│           │   │   │   └── XmlBeanDefinitionReader.java
│           │   │   ├── Aware.java
│           │   │   ├── BeanClassLoaderAware.java
│           │   │   ├── BeanFactory.java
│           │   │   ├── BeanFactoryAware.java
│           │   │   ├── BeanNameAware.java
│           │   │   ├── ConfigurableListableBeanFactory.java
│           │   │   ├── DisposableBean.java
│           │   │   ├── FactoryBean.java
│           │   │   ├── HierarchicalBeanFactory.java
│           │   │   ├── InitializingBean.java
│           │   │   ├── ListableBeanFactory.java
│           │   │   └── PropertyPlaceholderConfigurer.java
│           │   ├── BeansException.java
│           │   ├── PropertyValue.java
│           │   └── PropertyValues.java
│           ├── context
│           │   ├── annotation
│           │   │   ├── ClassPathBeanDefinitionScanner.java
│           │   │   ├── ClassPathScanningCandidateComponentProvider.java
│           │   │   └── Scope.java
│           │   ├── event
│           │   │   ├── AbstractApplicationEventMulticaster.java
│           │   │   ├── ApplicationContextEvent.java
│           │   │   ├── ApplicationEventMulticaster.java
│           │   │   ├── ContextClosedEvent.java
│           │   │   ├── ContextRefreshedEvent.java
│           │   │   └── SimpleApplicationEventMulticaster.java
│           │   ├── support
│           │   │   ├── AbstractApplicationContext.java
│           │   │   ├── AbstractRefreshableApplicationContext.java
│           │   │   ├── AbstractXmlApplicationContext.java
│           │   │   ├── ApplicationContextAwareProcessor.java
│           │   │   └── ClassPathXmlApplicationContext.java
│           │   ├── ApplicationContext.java
│           │   ├── ApplicationContextAware.java
│           │   ├── ApplicationEvent.java
│           │   ├── ApplicationEventPublisher.java
│           │   ├── ApplicationListener.java
│           │   └── ConfigurableApplicationContext.java
│           ├── core.io
│           │   ├── ClassPathResource.java
│           │   ├── DefaultResourceLoader.java
│           │   ├── FileSystemResource.java
│           │   ├── Resource.java
│           │   ├── ResourceLoader.java
│           │   └── UrlResource.java
│           ├── stereotype
│           │   └── Component.java
│           └── utils
│               ├── ClassUtils.java
│               └── StringValueResolver.java
└── test
└── java
└── cn.bugstack.springframework.test
├── bean
│   ├── IUserService.java
│   └── UserService.java
└── ApiTest.java

