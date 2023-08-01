package com.salpreh.algorithms.algorithms;

public interface SortedSearchAlgorithm<T extends Comparable<T>, R> {

  /**
   * Returns the index of the item.
   * @param item
   * @return Result of the search
   */
  R search(T item);

  /**
   * Returns true if the item is in the collection.
   * @param item
   * @return <code>true</code> if the item is in the collection, <code>false</code> otherwise
   */
  boolean contains(T item);
}
