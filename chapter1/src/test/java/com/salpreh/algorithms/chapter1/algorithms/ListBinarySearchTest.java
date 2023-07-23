package com.salpreh.algorithms.chapter1.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListBinarySearchTest {

  private static final List<Integer> SORTED_LIST = List.of(1, 3, 3, 4, 5, 8, 12, 20, 22, 30, 33, 35, 35, 37, 40, 55);

  @Test
  void givenSortedList_whenSearch_shouldFindItem() {
    // given
    ListBinarySearch<Integer> search = new ListBinarySearch<>(SORTED_LIST);

    // when
    int idx = search.search(5);

    // then
    assertEquals(4, idx);
  }

  @Test
  void givenSortedList_whenSearch_shouldNotFindItem() {
    // given
    ListBinarySearch<Integer> search = new ListBinarySearch<>(SORTED_LIST);

    // when
    int idx = search.search(6);

    // then
    assertEquals(-1, idx);
  }

  @Test
  void givenSortedList_whenSearchDuplicated_shouldFindItem() {
    // given
    ListBinarySearch<Integer> search = new ListBinarySearch<>(SORTED_LIST);

    // when
    int idx = search.search(35);

    // then
    assertEquals(11, idx);
  }

  @Test
  void givenEmptyList_whenSearch_shouldNotFindItem() {
    // given
    ListBinarySearch<Integer> search = new ListBinarySearch<>(new ArrayList<Integer>());

    // when
    int idx = search.search(6);

    // then
    assertEquals(-1, idx);
  }
}
