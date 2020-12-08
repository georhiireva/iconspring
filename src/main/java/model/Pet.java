package model;

import jdk.jshell.spi.ExecutionControl;
import util.Utils;

public abstract class Pet implements ISpeaker {
    private String _name;

    public Pet(String name) {
        _name = name;
        Utils.printConstructor(this.toString());
    }

    public void say() {
        System.out.println(this.getClass() + " " + _name + " says: \"Hello world!\"");
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "_name='" + _name + '\'' +
                '}';
    }

    @Override
    public String talkWithOther(String in_message, Person otherPerson) {
        return null;
    }

    @Override
    public String talkWithException() throws Throwable {
        throw new ExecutionControl.NotImplementedException("Pet doesn't want to talk with undefined person!");
    }
}
