package com.salpreh.algorithms.chapter4.exercises;

import java.util.Collection;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DNCExercises {

  public static int sum(List<Integer> list) {
    if (list.isEmpty()) return 0;

    return list.get(0) + sum(list.subList(1, list.size()));
  }

  public static <T> int count(List<T> list) {
    if (list.isEmpty()) return 0;

    return 1 + count(list.subList(1, list.size()));
  }

  public static <T extends Comparable<T>> T max(List<T> list) {
    if (list.isEmpty()) return null;
    if (list.size() == 1) return list.get(0);

    T item = list.get(0);
    T max = max(list.subList(1, list.size()));
    max = item.compareTo(max) > 0
      ? item
      : max;

    return max;
  }

  public static <T extends Comparable<T>> int findIndexOf(List<T> list, T search) {
    if (list.isEmpty()) return -1;

    int mid = list.size() / 2;
    T item = list.get(mid);
    if (item.compareTo(search) == 0) return mid;
    if (item.compareTo(search) > 0) return findIndexOf(list.subList(0, mid), search);
    else {
      int idx = findIndexOf(list.subList(mid + 1, list.size()), search);
      return idx == -1 ? -1 : mid + 1 + idx;
    }
  }
}
