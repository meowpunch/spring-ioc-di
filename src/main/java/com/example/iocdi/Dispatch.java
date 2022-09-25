package com.example.iocdi;

import java.util.List;
import java.util.stream.Stream;

public class Dispatch {
  static class Service {
    void run(int i) {
      System.out.println("run(" + i +")");
    }

    void run(String s) {
      System.out.println("run(" + s +")");
    }
  }

  interface ServiceInterface {
    void run();
  }

  static class MyService implements ServiceInterface{

    @Override
    public void run() {
      System.out.println("MyService");
    }
  }

  static class YourService implements ServiceInterface {

    @Override
    public void run() {
      System.out.println("YourService");
    }
  }

  public static void main(String[] args) {
    // method overloading is about static dispatch, which means that it's already known in compile time which method's used.
    new Service().run(1);
    new Service().run("1");

    // Dynamically determined which class method will be used.
    Stream.of(new MyService(), new YourService()).forEach(ServiceInterface::run); // receiver parameter is determined in runtime
  }
}

class MethodSignatureAndType {
  // method signature: name, parameter types not return type
  String method(Integer i) {return i.toString();}

  // 'method(Integer)' is already defined in 'com.example.iocdi.MethodSignature'
  // Integer method(Integer i) {return i;}

  // method type: return type, method type parameter. method argument types, exception => allow to use method reference
  public static void main(String[] args) {}
}

class DoubleDispatcher {
  interface Content {}
  record Text () implements Content {}
  record Picture () implements Content {}

  interface SNSService {
    default void post(Content content) {
      System.out.println("Success to post " + content.getClass().getSimpleName() + " to " + this.getClass().getSimpleName());
    }
  }
  static class Facebook implements SNSService {}
  static class Twitter implements SNSService {}
  static class TicTok implements SNSService {}

  static final List<SNSService> allServices = List.of(new Facebook(), new Twitter(), new TicTok());
  public static void main(String[] args) {
    Stream.of(new Text(), new Picture()).forEach(content -> allServices.forEach(s -> s.post(content)));
  }
}