package com.salpreh.algorithms.chapter2.algorithms;

import com.salpreh.algorithms.algorithms.CollectionSorter;
import java.util.ArrayList;
import java.util.List;

public class ListSelectionSort<T extends Comparable<T>> implements CollectionSorter<List<T>> {

  @Override
  public List<T> sort(List<T> collection) {
    List<T> itemsToProcess = new ArrayList<>(collection);
    List<T> sortedCollection = new ArrayList<>(collection.size());
    while (!itemsToProcess.isEmpty()) {
      int minIdx = findSmallerIndex(itemsToProcess);
      sortedCollection.add(itemsToProcess.remove(minIdx));
    }

    return sortedCollection;
  }

  private int findSmallerIndex(List<T> collection) {
    if (collection.isEmpty()) return -1;

    int minIdx = 0;
    T min = collection.get(minIdx);
    for (int i = 1; i < collection.size(); i++) {
      if (collection.get(i).compareTo(min) < 0) {
        min = collection.get(i);
        minIdx = i;
      }
    }

    return minIdx;
  }
}
