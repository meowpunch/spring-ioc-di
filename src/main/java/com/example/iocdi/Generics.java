package com.example.iocdi;

import java.util.List;

public class Generics {

  static class A {}
  static class B extends A {}
  static <T extends Comparable<T>> List<T> greaterThan(List<T> list, T t) {
    return list.stream().filter(e -> t.compareTo(e) > 0).toList();
  }

  static void printList(List<Object> objectList) {
    objectList.forEach(System.out::println);
  }

  static void printWildList(List<?> list) {
    list.forEach(System.out::println);
  }

  public static void main(String[] args) {
    List<B> bList = List.of(new B(), new B());
//    List<A> aList = bList;
    List<? extends A> aList = bList;

    System.out.println(greaterThan(List.of(1, 2, 3, 4, 5, 6), 5));
    System.out.println(greaterThan(List.of("a", "b", "c", "d", "e", "f"), "e"));

    printList(List.of(1, 2, 3, 4, 5, 6));
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
//    printList(integerList);
    printWildList(integerList);
  }

}
