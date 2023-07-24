package com.salpreh.algorithms.structures;

public interface SortedStructure<T extends Comparable<T>> {
  void add(T item);
  void remove(T item);
}
