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
        person.talkWithOther("How are you?", new Person("Michael", 22, null));
        try {
            person.talkWithException();
        } catch( Throwable exception) {

        }


        context.close();
    }
}
