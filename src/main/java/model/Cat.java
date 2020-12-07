package model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cat extends Pet {
    public Cat(@Value("${cat.name}") String name) {
        super(name);
    }
}
