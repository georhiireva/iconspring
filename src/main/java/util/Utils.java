package util;

public class Utils {
    public static void printConstructor(String whoCreated) {
        System.out.println(whoCreated + " is created!");
    }

    public static void printSetter(String whoSetted, String target) {
        System.out.println(whoSetted + " is setted to " + target);
    }

    public static void printMethod(String methodName) {
        System.out.println(methodName + " is called!");
    }
}
