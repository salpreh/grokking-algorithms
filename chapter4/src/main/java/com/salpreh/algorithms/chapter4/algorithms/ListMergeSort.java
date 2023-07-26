package com.salpreh.algorithms.chapter4.algorithms;

import com.salpreh.algorithms.algorithms.CollectionSorter;
import java.util.ArrayList;
import java.util.List;

public class ListMergeSort<T extends Comparable<T>> implements CollectionSorter<List<T>> {

  @Override
  public List<T> sort(List<T> list) {
    if (list.size() <= 1) return list;

    int mid = list.size() / 2;
    List<T> leftSubList = sort(list.subList(0, mid));
    List<T> rightSubList = sort(list.subList(mid, list.size()));

    int leftIdx = 0;
    int rightIdx = 0;
    List<T> sortedList = new ArrayList<>(leftSubList.size() + rightSubList.size());
    while (leftIdx < leftSubList.size() && rightIdx < rightSubList.size()) {
      if (leftSubList.get(leftIdx).compareTo(rightSubList.get(rightIdx)) < 0) {
        sortedList.add(leftSubList.get(leftIdx++));
      } else {
        sortedList.add(rightSubList.get(rightIdx++));
      }
    }

    while (leftIdx < leftSubList.size()) sortedList.add(leftSubList.get(leftIdx++));
    while (rightIdx < rightSubList.size()) sortedList.add(rightSubList.get(rightIdx++));

    return sortedList;
  }
}
