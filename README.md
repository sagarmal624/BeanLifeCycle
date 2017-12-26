# BeanLifeCycle

![alt text](http://javasampleapproach.com/wp-content/uploads/2016/09/bean-life-cycle.jpg)

# How to invoke spring bean init and destroy methods?

You can define initialization and destroy methods with in the spring bean.
You can configure it using init-method, and destroy-method in the xml based configuration file. 
These are part of spring bean life cycle. The initialization method will be called immediately after bean creation, and destroy method will be called before killing the bean instance.
```xml
  <bean name="personService" class="com.sagarandcompany.BeanLifeCycle.initAndDestroyMethodAttribute.PersonService" init-method="init" destroy-method="destroy">
    <property name="name" value="Sagar"/>
    <property name="visibility" value="Sagarmal624@gmail.com"/>
    <property name="age" value="25"/>
    </bean>
```    
```java
public class PersonService {
    private String name;
    private String visibility;
    private Integer age;

    public void init() {
        System.out.println("calling init method after setting all values.........." + this.toString());
    }

    public void destroy() {
        System.out.println("calling this destroy method ");
    }
}
```

# Initialization and destruction callback

org.springframework.beans.factory.InitializingBean inteface with in your spring bean. You need implement afterPropertiesSet() method, and write all initialization code with in this method.

implementing org.springframework.beans.factory.DisposableBean interface with in your spring bean. You need to implement destroy() method with in your spring bean and move all of your clean up code with in destroy() method.
```xml

<bean name="empService"
          class="com.sagarandcompany.BeanLifeCycle.InitializingBeanAndDisposableBeanInterface.EmpService">
        <property name="name" value="Sagar"/>
        <property name="visibility" value="Sagarmal624@gmail.com"/>
        <property name="age" value="25"/>
    </bean>
```

```java
public class EmpService implements InitializingBean, DisposableBean {
    private String name;
    private String visibility;
    private Integer age;

    @Override
    public void afterPropertiesSet() {
        System.out.println("calling afterPropertiesSet method after setting all values.........." + this.toString());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("calling this destroy method ");
    }
```
# Spring bean init and destroy methods using annotations @PostConstruct and @PreDestroy
In the previous example you have seen calling spring bean initialization and destroy methods using xml bean configurations.
This page shows how to configure spring bean initialization and destroy method calls using java annotations @PostConstruct and @PreDestroy. 
These annotations are not belong to spring API, these are part of J2ee library common-annotations.jar file.

you must include context:annotation-config tag.
```xml
 <bean name="userService" class="com.sagarandcompany.BeanLifeCycle.PostConstructAndPreDestroyAnnotation.UserService">
        <property name="name" value="Sagar"/>
        <property name="visibility" value="Sagarmal624@gmail.com"/>
        <property name="age" value="25"/>
    </bean>
 <context:annotation-config />
```

```java
public class UserService {
    private String name;
    private String visibility;
    private Integer age;

    @PostConstruct
    public void postConstruct() {
        System.out.println("calling postConstruct method after setting all values.........." + this.toString());
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("calling this destroy method ");
    }
}
```
# Configure default initialization and destroy methods in all spring beans
In case, if you have many spring beans with initialization and destory method, then you need to define init-method and destroy-method on each individual spring bean. Spring provides an alternative and flexible way to configure this. You can define only once with same method signature and you can use across all spring beans. You need to configure default-init-method and default-destroy-method attributes on the <beans> element. This example shows how to configure it.
```xml  
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
       default-init-method="init"
       default-destroy-method="destroy"
>

    <bean name="personService" class="com.sagarandcompany.BeanLifeCycle.initAndDestroyMethodAttribute.PersonService"
          init-method="init" destroy-method="destroy">
        <property name="name" value="Sagar"/>
        <property name="visibility" value="Sagarmal624@gmail.com"/>
        <property name="age" value="25"/>
    </bean>

</beans>
```
```java
public class PersonService {
    private String name;
    private String visibility;
    private Integer age;

    public void init() {
        System.out.println("calling init method after setting all values.........." + this.toString());
    }

    public void destroy() {
        System.out.println("calling this destroy method ");
    }
}
```

# Spring Bean Post Processors


BeanPostProcessor gives you a way to do some operations before creating the spring bean and immediately after creating the spring bean. This allows you to add some custom logic before and after spring bean creation. The BeanPostProcessors operate on bean (or object) instances which means that the Spring IoC container instantiates a bean instance and then BeanPostProcessor interfaces do their work.

Notice that the init and destroy methods related to bean are different from bean post processors. BeanPostProcessors are common for all beans. This example clearly shows the difference from them.

The IoC container calls BeanPostProcessor.postProcessBeforeInitialization() before @PostConstruct and InitializingBean.afterPropertiesSet() method, then calls BeanPostProcessor.postProcessAfterInitialization() (after custom init method).

To implement bean post processor logic, we need to create a class which implements BeanPostProcessor interface and two of its methods.
```xml
    <bean class="com.sagarandcompany.BeanLifeCycle.SpringBeanPostProcessors.MyBeanInitProcessor"/>

```
```java
public class MyBeanInitProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before initialization: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after initialization: " + beanName);
        return bean;
    }

}

```
