package com.example.iocdi;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Generics {

  static class A {

  }

  static class B extends A {

  }

  static <T extends Comparable<T>> List<T> greaterThan(List<T> list, T t) {
    return list.stream().filter(e -> t.compareTo(e) > 0).toList();
  }

  static void printList(List<Object> objectList) {
    objectList.forEach(System.out::println);
  }

  // not recommended
  static <T> void printGenericList(List<T> list) {
    list.forEach(System.out::println);
  }

  static void printWildList(List<?> list) {
    list.forEach(System.out::println);
  }

  // not recommended
  static <T> long genericFrequency(List<T> list, T t) {
    return list.stream().filter(t::equals).count();
  }

  static long wildFrequency(List<?> list, Object o) {
    return list.stream().filter(o::equals).count();
  }

  public static void main(String[] args) {
    List<B> bList = List.of(new B(), new B());
    // compile error. B extends A but List<B> doesn't extend List<A>
    // List<A> aList = bList;
    List<? extends A> aList = bList;
    List<? extends Number> numbers = List.of(Integer.valueOf("0"), Long.MAX_VALUE, BigDecimal.valueOf(10));

    System.out.println(greaterThan(List.of(1, 2, 3, 4, 5, 6), 5));
    System.out.println(greaterThan(List.of("a", "b", "c", "d", "e", "f"), "e"));

    printList(List.of(1, 2, 3, 4, 5, 6));
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
//    printList(integerList);
    printGenericList(integerList);
    printWildList(integerList);
  }
}

class AdvancedGenerics {

  private static <T extends Comparable<T>> T max(List<T> list) {
    return list.stream().reduce((a, b) -> a.compareTo(b) > 0 ? a : b).orElseThrow();
  }

  private static <T extends Comparable<? super T>> T advancedMax(List<? extends T> list) {
    return list.stream().reduce((a, b) -> a.compareTo(b) > 0 ? a : b).orElseThrow();
  }

  public static void main(String[] args) {}
}
