package com.salpreh.algorithms.chapter9.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  private List<Item> createItems() {
    return List.of(
      new Item("A", 1, 1D),
      new Item("B", 2, 2.5D),
      new Item("C", 3, 3D)
    );
  }
}
