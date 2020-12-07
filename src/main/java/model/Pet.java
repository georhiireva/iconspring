package model;

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
}
