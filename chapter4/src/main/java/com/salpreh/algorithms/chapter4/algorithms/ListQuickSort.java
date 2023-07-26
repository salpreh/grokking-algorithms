package com.salpreh.algorithms.chapter4.algorithms;

import com.salpreh.algorithms.algorithms.CollectionSorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListQuickSort<T extends Comparable<T>> implements CollectionSorter<List<T>> {

  private static final Random random = new Random();

  @Override
  public List<T> sort(List<T> list) {
    if (list.size() <= 1) return list;

    int pivotIdx = getPivotIdx(list);
    T pivot = list.get(pivotIdx);
    List<T> leftList = new ArrayList<>(list.size());
    List<T> rightList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      if (i == pivotIdx) continue;

      T item = list.get(i);
      if (pivot.compareTo(item) > 0) leftList.add(item);
      else rightList.add(item);
    }

    leftList = sort(leftList);
    rightList = sort(rightList);

    List<T> sortedList = leftList;
    sortedList.add(pivot);
    sortedList.addAll(rightList);

    return sortedList;
  }

  private int getPivotIdx(List<T> collection) {
    return random.nextInt(0, collection.size());
  }
}
