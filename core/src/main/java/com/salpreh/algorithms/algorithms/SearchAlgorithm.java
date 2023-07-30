package com.salpreh.algorithms.algorithms;

public interface SearchAlgorithm<T, R> {

  /**
   * Performs the search and return the response.
   * @param item
   * @return Result of the search, or <code>null</code> if not found
   */
  R search(T item);
}
