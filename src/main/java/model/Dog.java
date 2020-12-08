package model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Dog extends Pet {
    public Dog(@Value("${dog.name}") String name) {
        super(name);
    }

    @Override
    public void say() {
        System.out.println("I don't want to say like a usual pet!");
    }
}
