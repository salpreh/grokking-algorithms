package com.salpreh.algorithms.chapter4.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ListQuickSortTest {

  private static List<Integer> UNSORTED_LIST = List.of(4, 5, 1, 12, 3, 20, 22, 15, 14, 10, 20, 32, 5);
  private ListQuickSort<Integer> quickSort = new ListQuickSort<>();

  @Test
  void givenUnsortedList_whenSorted_thenListSorted() {
    // when
    List<Integer> sortedList = quickSort.sort(UNSORTED_LIST);

    // then
    assertEquals(1, sortedList.get(0));
    assertEquals(5, sortedList.get(3));
    assertEquals(15, sortedList.get(8));
    assertEquals(20, sortedList.get(10));
    assertEquals(32, sortedList.get(12));
  }

  @Test
  void givenEmptyList_whenSorted_thenEmptyList() {
    // when
    List<Integer> sortedList = quickSort.sort(List.of());

    // when
    assertTrue(sortedList.isEmpty());
  }
}
