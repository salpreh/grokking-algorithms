package com.salpreh.algorithms.chapter4.exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class DNCExercisesTest {

  @Test
  void givenIntegerList_whensSum_thenReturnTotal() {
    // given
    List<Integer> list = List.of(1, 4, 5, 9, 1, 10, 2);

    // when
    int sum = DNCExercises.sum(list);

    // then
    assertEquals(32, sum);
  }

  @Test
  void givenEmptyList_whensSum_thenReturnZero() {
    // given
    List<Integer> list = List.of();

    // when
    int sum = DNCExercises.sum(list);

    // then
    assertEquals(0, sum);
  }

  @Test
  void givenIntegerList_whensCount_thenReturnTotal() {
    // given
    List<Integer> list = List.of(1, 4, 5, 9, 1, 10, 2);

    // when
    int count = DNCExercises.count(list);

    // then
    assertEquals(7, count);
  }

  @Test
  void givenEmptyList_whensCount_thenReturnZero() {
    // given
    List<Integer> list = List.of();

    // when
    int count = DNCExercises.count(list);

    // then
    assertEquals(0, count);
  }

  @Test
  void givenIntegerList_whensMax_thenReturnMax() {
    // given
    List<Integer> list = List.of(1, 4, 5, 9, 1, 10, 2);

    // when
    int max = DNCExercises.max(list);

    // then
    assertEquals(10, max);
  }

  @Test
  void givenEmptyList_whensMax_thenReturnNull() {
    // given
    List<Integer> list = List.of();

    // when
    Integer max = DNCExercises.max(list);

    // then
    assertNull(max);
  }

  @Test
  void givenSortedList_whenFindIndexOf_thenReturnIndex() {
    // given
    List<Integer> list = List.of(1, 4, 5, 9, 10, 12, 15, 20, 22, 32);

    // when
    int idx = DNCExercises.findIndexOf(list, 10);

    // then
    assertEquals(4, idx);
  }

  @Test
  void givenSortedList_whenFindFirstIndex_thenReturnIndex() {
    // given
    List<Integer> list = List.of(1, 4, 5, 9, 10, 12, 15, 20, 22, 32);

    // when
    int idx = DNCExercises.findIndexOf(list, 1);

    // then
    assertEquals(0, idx);
  }

  @Test
  void givenSortedList_whenFindLastIndex_thenReturnIndex() {
    // given
    List<Integer> list = List.of(1, 4, 5, 9, 10, 12, 15, 20, 22, 32);

    // when
    int idx = DNCExercises.findIndexOf(list, 32);

    // then
    assertEquals(9, idx);
  }

  @Test
  void givenSortedList_whenFindNonExistentIndex_thenReturnNotFound() {
    // given
    List<Integer> list = List.of(1, 4, 5, 9, 10, 12, 15, 20, 22, 32);

    // when
    int idx = DNCExercises.findIndexOf(list, 11);

    // then
    assertEquals(-1, idx);
  }

  @Test
  void givenEmptyList_whenFindIndexOf_thenReturnNotFound() {
    // given
    List<Integer> list = List.of();

    // when
    int idx = DNCExercises.findIndexOf(list, 10);

    // then
    assertEquals(-1, idx);
  }
}
