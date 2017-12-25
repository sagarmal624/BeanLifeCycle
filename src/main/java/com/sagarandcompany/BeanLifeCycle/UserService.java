package com.sagarandcompany.BeanLifeCycle;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserService implements InitializingBean {
    private String name;
    private String email;
    private Integer age;

    @Override
    public void afterPropertiesSet() {
        System.out.println("calling this method after setting all values.........." + this.toString());
    }


    public void initIt() throws Exception {
        System.out.println("Init method after properties are set : " + this.toString());
    }

    public void cleanUp() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("calling setter");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmpService{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
