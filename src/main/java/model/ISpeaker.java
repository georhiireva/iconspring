package model;

public interface ISpeaker {
    void say();
    String talkWithOther(String in_message, Person otherPerson);
    String talkWithException() throws Throwable;
}
