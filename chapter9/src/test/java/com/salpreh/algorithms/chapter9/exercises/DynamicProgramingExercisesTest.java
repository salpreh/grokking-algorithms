package com.salpreh.algorithms.chapter9.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.salpreh.algorithms.chapter9.models.Item;
import java.util.List;
import org.junit.jupiter.api.Test;

class DynamicProgramingExercisesTest {

  @Test
  void givenKnapsack_whenFindBestValue_shouldReturn() {
    // given
    List<Item> items = createItems();
    int knapsackSize = 3;

    // when
    double result = DynamicProgramingExercises.knapsackGetBestValue(knapsackSize, items);

    // then
    assertEquals(3.5D, result);
  }

  @Test
  void givenKnapsack_whenFindBestValueItems_shouldReturn() {
    // given
    List<Item> items = createItems();
    int knapsackSize = 3;

    // when
    var result = DynamicProgramingExercises.knapsackGetBestValueItems(knapsackSize, items);

    // then
    assertEquals(3.5D, result.second());

    List<Item> resultItems = result.first();
    assertEquals("B", resultItems.get(0).name());
    assertEquals("A", resultItems.get(1).name());
  }

  @Test
  void givenNumber_whenCalculateFibonacci_shouldReturn() {
    // when
    int result = DynamicProgramingExercises.fibonacci(6);

    // then
    assertEquals(8, result);
  }

  @Test
  void givenNumber_whenCalculateFibonacciBottomUp_shouldReturn() {
    // when
    int result = DynamicProgramingExercises.fibonacciBottomUp(6);

    // then
    assertEquals(8, result);
  }

  @Test
  void givenGridSize_whenCalculateGridOptions_shouldReturn() {
    // when
    int result = DynamicProgramingExercises.travellerGridOptions(4, 3);

    // then
    assertEquals(10, result);

  }

  @Test
  void givenGridSize_whenCalculateGridOptionsBottomUp_shouldReturn() {
    // when
    int result = DynamicProgramingExercises.travellerGridOptionsBottomUp(4, 3);

    // then
    assertEquals(10, result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateCanSum_shouldReturnTrue() {
    // given
    int target = 13;
    List<Integer> numbers = List.of(2, 3, 4);

    // when
    boolean result = DynamicProgramingExercises.canSum(target, numbers);

    // then
    assertTrue(result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateCanSum_shouldReturnFalse() {
    // given
    int target = 122;
    List<Integer> numbers = List.of(3, 6);

    // when
    boolean result = DynamicProgramingExercises.canSum(target, numbers);

    // then
    assertFalse(result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateCanSumBottomUp_shouldReturnTrue() {
    // given
    int target = 13;
    List<Integer> numbers = List.of(2, 3, 4);

    // when
    boolean result = DynamicProgramingExercises.canSumBottomUp(target, numbers);

    // then
    assertTrue(result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateCanSumBottomUp_shouldReturnFalse() {
    // given
    int target = 122;
    List<Integer> numbers = List.of(3, 6);

    // when
    boolean result = DynamicProgramingExercises.canSumBottomUp(target, numbers);

    // then
    assertFalse(result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateCanSumBottomUp2_shouldReturnTrue() {
    // given
    int target = 13;
    List<Integer> numbers = List.of(2, 3, 4);

    // when
    boolean result = DynamicProgramingExercises.canSumBottomUp2(target, numbers);

    // then
    assertTrue(result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateCanSumBottomUp2_shouldReturnFalse() {
    // given
    int target = 122;
    List<Integer> numbers = List.of(3, 6);

    // when
    boolean result = DynamicProgramingExercises.canSumBottomUp2(target, numbers);

    // then
    assertFalse(result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateHowSum_shouldReturnNumbers() {
    // given
    int target = 13;
    List<Integer> numbers = List.of(2, 3, 4);

    // when
    List<Integer> result = DynamicProgramingExercises.howSum(target, numbers);

    // then
    assertEquals(List.of(3, 2, 2, 2, 2, 2), result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateHowSumAndTargetNotReachable_shouldReturnNull() {
    // given
    int target = 7;
    List<Integer> numbers = List.of(3, 5, 9);

    // when
    List<Integer> result = DynamicProgramingExercises.howSum(target, numbers);

    // then
    assertNull(result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateHowSumBottomUp_shouldReturnNumbers() {
    // given
    int target = 13;
    List<Integer> numbers = List.of(2, 3, 4);

    // when
    List<Integer> result = DynamicProgramingExercises.howSumBottomUp(target, numbers);

    // then
    assertEquals(List.of(3, 2, 2, 2, 2, 2), result);
  }

  @Test
  void givenNumbersAndTarget_whenCalculateHowSumBottomUpAndTargetNotReachable_shouldReturnNull() {
    // given
    int target = 7;
    List<Integer> numbers = List.of(3, 5, 9);

    // when
    List<Integer> result = DynamicProgramingExercises.howSumBottomUp(target, numbers);

    // then
    assertNull(result);
  }

  private List<Item> createItems() {
    return List.of(
      new Item("A", 1, 1D),
      new Item("B", 2, 2.5D),
      new Item("C", 3, 3D)
    );
  }
}
