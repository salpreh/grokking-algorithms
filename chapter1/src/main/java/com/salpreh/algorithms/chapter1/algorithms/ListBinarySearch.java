package com.salpreh.algorithms.chapter1.algorithms;

import com.salpreh.algorithms.algorithms.SortedSearchAlgorithm;
import java.util.List;

public class ListBinarySearch<T extends Comparable<T>> implements SortedSearchAlgorithm<T, Integer> {

  private final List<T> list;

  public ListBinarySearch(List<T> list) {
    this.list = list;
  }

  @Override
  public Integer search(T item) {
    int low = 0;
    int high = list.size() - 1;
    int idx;

    while (low <= high) {
      idx = (low + high) / 2;
      T candidate = list.get(idx);
      if (candidate.compareTo(item) == 0) return idx;
      else if (candidate.compareTo(item) < 0) low = idx + 1;
      else high = idx - 1;
    }

    return -1;
  }

  @Override
  public boolean contains(T item) {
    return search(item) != -1;
  }
}
