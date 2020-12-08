package model;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import util.Utils;

@Component
@Scope("prototype")
public class Person implements ISpeaker {
    private String _name;
    private int _age;
    private Pet _pet;

    @Autowired
    public Person(@Value("${person.name}") String name, @Value("${person.age}") int age, @Qualifier("dog") Pet pet) {
        _name = name;
        _age = age;
        _pet = pet;
        Utils.printConstructor(this.toString());
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int age) {
        _age = age;
    }

    public Pet getPet() {
        return _pet;
    }

    public void setPet(Pet pet) {
        _pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _pet=" + _pet +
                '}';
    }

    @Override
    public void say() {
        System.out.println(this.getClass() + " " + _name + " says: " + _pet.getName() + ", come here!");
        _pet.say();
    }

    @Override
    public String talkWithOther(String in_message, Person otherPerson) {
        return "Hey, " + otherPerson.getName() + ", you said, " + in_message + "?. Let's talk about it.";
    }

    @Override
    public String talkWithException() throws Throwable {
        throw new ExecutionControl.NotImplementedException("Person doesn't want to talk with undefined person!");
    }
}
