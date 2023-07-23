package com.salpreh.algorithms.algorithms;

public interface SortedSearch<T extends Comparable<T>> {

  /**
   * Returns the index of the item.
   * @param item
   * @return index of the item, or -1 if not found
   */
  int search(T item);

  /**
   * Returns true if the item is in the collection.
   * @param item
   * @return <code>true</code> if the item is in the collection, <code>false</code> otherwise
   */
  boolean contains(T item);
}
