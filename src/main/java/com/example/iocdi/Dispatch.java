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
  interface Content {
    void postOn(SNSService service);
  }
  record Text () implements Content {

    @Override
    public void postOn(SNSService service) {
      service.post(this);
    }
  }
  record Picture () implements Content {

    @Override
    public void postOn(SNSService service) {
      service.post(this);
    }
  }

  interface SNSService {
    void post(Text text);
    void post(Picture picture);
  }
  static class Facebook implements SNSService {

    @Override
    public void post(Text text) {
      System.out.println("process text to post Facebook");
    }

    @Override
    public void post(Picture picture) {
      System.out.println("process picture to post Facebook");
    }
  }
  static class Twitter implements SNSService {

    @Override
    public void post(Text text) {
      System.out.println("process text to post Twitter");
    }

    @Override
    public void post(Picture picture) {
      System.out.println("process picture to post Twitter");
    }
  }
  static class TicTok implements SNSService {

    @Override
    public void post(Text text) {
      System.out.println("process text to post TicTok");
    }

    @Override
    public void post(Picture picture) {
      System.out.println("process picture to post TicTok");
    }
  }

  /*
       Which parts should be extensible? Service tend to be added easily. The number of content's type would be more stable.

   */
  static final List<SNSService> allServices = List.of(new Facebook(), new Twitter(), new TicTok());
  static final Stream<Content> contentStream = Stream.of(new Text(), new Picture());
  public static void main(String[] args) {
    // post contents to all services
    contentStream.forEach(content -> allServices.forEach(content::postOn));
  }
}