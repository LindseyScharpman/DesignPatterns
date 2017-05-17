package singleton;

import java.io.*;
import java.util.HashMap;
import java.util.stream.Stream;

public class TestSingleton {
    public static void main(String[] args) throws Exception {
        testM1();
        System.out.println();
        testM2();
        System.out.println();
        testM3();
    }

    private static void testM3() throws Exception {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.print((s1 == s2) + ":");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton2.txt"));
        oos.writeObject(s1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton2.txt"));
        Object s3 = ois.readObject();
        System.out.println((s3 == s1) + ":" + (s3 == s2));
    }

    private static void testM1() throws Exception {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        System.out.print((s1 == s2) + ":");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton1.txt"));
        oos.writeObject(s1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton1.txt"));
        Object s3 = ois.readObject();
        System.out.println((s3 == s1) + ":" + (s3 == s2));
    }

    private static void testM2() throws Exception {
        SingletonEnum s1 = SingletonEnum.INSTANCE;
        SingletonEnum s2 = SingletonEnum.INSTANCE;
        s1.doSomething();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singletonEnum.txt"));
        oos.writeObject(s1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singletonEnum.txt"));
        Object s3 = ois.readObject();
        System.out.println((s3 == s1) + ":" + (s3 == s2));
        System.out.println(((SingletonEnum) s3).getName());
    }

}
