package com.sagarandcompany.BeanLifeCycle;

import com.sagarandcompany.BeanLifeCycle.PostConstructAndPreDestroyAnnotation.UserService;
import com.sagarandcompany.BeanLifeCycle.initAndDestroyMethodAttribute.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BeanLifeCycleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanLifeCycleApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        EmpService empService = (EmpService) context.getBean("empService");
//        System.out.println(empService.toString());

//        PersonService personService = (PersonService) context.getBean("personService");
//        System.out.println(personService.toString());

        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.toString());


    }
}
