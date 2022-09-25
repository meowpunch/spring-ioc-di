package com.example.iocdi;

public class TypeToken {

  static class Wrapper<T> {

    private T value;

    void set(T t) {
      this.value = t;
    }

    T get() {
      return value;
    }
  }

  public static void main(String[] args) {
    var stringWrapper = new Wrapper<String>();
    stringWrapper.set("meow");
  }
}

