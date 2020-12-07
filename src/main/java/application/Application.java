package application;

import configuration.AppConfig;
import model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        var person = context.getBean(Person.class);
        person.say();

        context.close();
    }
}
