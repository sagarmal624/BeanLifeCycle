package com.sagarandcompany.BeanLifeCycle.SpringBeanPostProcessors;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TopicService {
    private String name;
    private String visibility;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("calling name setter");
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
        System.out.println("calling visibility setter");

    }


    @Override
    public String toString() {
        return "EmpService{" +
                "name='" + name + '\'' +
                ", visibility='" + visibility + '\'' +
                '}';
    }
}
