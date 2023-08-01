package com.salpreh.algorithms.chapter9.exercises;

import com.salpreh.algorithms.chapter9.models.Item;
import com.salpreh.algorithms.models.Tuple;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DynamicProgramingExercises {

  public static double knapsackGetBestValue(int knapsackSize, List<Item> items) {
    double[][] resultTable = new double[items.size() + 1][knapsackSize + 1];

    for (int i = 1; i <= items.size(); i++) {
      Item item = items.get(i - 1);
      for (int j = 1; j <= knapsackSize; j++) {
        if (item.size() <= j && item.value() + resultTable[i-1][j-item.size()] > resultTable[i-1][j]) {
          resultTable[i][j] = item.value() + resultTable[i-1][j-item.size()];
        } else {
          resultTable[i][j] = resultTable[i-1][j];
        }
      }
    }

    return resultTable[items.size()][knapsackSize];
  }

  public static Tuple<List<Item>, Double> knapsackGetBestValueItems(int knapsackSize, List<Item> items) {
    double[][] resultTable = new double[items.size() + 1][knapsackSize + 1];
    Integer[][] backtrack = new Integer[items.size() + 1][knapsackSize + 1];

    for (int i = 1; i <= items.size(); i++) {
      Item item = items.get(i - 1);
      for (int j = 1; j <= knapsackSize; j++) {
        if (item.size() <= j && item.value() + resultTable[i-1][j-item.size()] > resultTable[i-1][j]) {
          resultTable[i][j] = item.value() + resultTable[i-1][j-item.size()];
          backtrack[i][j] = j-item.size();
        } else {
          resultTable[i][j] = resultTable[i-1][j];
          backtrack[i][j] = j;
        }
      }
    }

    return Tuple.of(
      getKnapsackBestValueItems(resultTable, backtrack, items),
      resultTable[items.size()][knapsackSize]
    );
  }

  public static int fibonacci(int num) {
    if (num < 1) return 0;
    int[] results = new int[num + 1];

    return fibonacci(num, results);
  }

  private static int fibonacci(int num, int[] results) {
    if (num < 1) return 0;

    if (num <= 2) results[num] = 1;
    else {
      int left = results[num-1] != 0 ? results[num-1] : fibonacci(num - 1, results);
      int right = results[num-2] != 0 ? results[num-2] : fibonacci(num - 2, results);
      results[num] = left + right;
    }

    return results[num];
  }

  public static int fibonacciBottomUp(int num) {
    if (num < 1) return 0;
    if (num <= 2) return 1;

    int[] results = new int[num + 1];
    results[1] = 1;
    results[2] = 1;
    for (int i = 3; i <= num; i++) {
      results[i] = results[i-1] + results[i-2];
    }

    return results[num];
  }

  public static int travellerGridOptions(int width, int height) {
    if (width <= 0 || height <= 0) return 0;

    return travellerGridOptions(width, height, new int[width+1][height+1]);
  }

  private static int travellerGridOptions(int width, int height, int[][] results) {
    if (width == 0 || height == 0) return 0;
    if (width == 1 && height == 1) results[width][height] =  1;
    else {
      int left = results[width-1][height] != 0
        ? results[width-1][height]
        : travellerGridOptions(width - 1, height, results);
      int right = results[width][height-1] != 0
        ? results[width][height-1]
        : travellerGridOptions(width, height - 1, results);

      results[width][height] = left + right;
    }

    return results[width][height];
  }

  public static int travellerGridOptionsBottomUp(int width, int height) {
    if (width == 0 || height ==0) return 0;
    if (width == 1 && height == 1) return 1;

    int[][] results = new int[width+1][height+1];
    for (int j = 1; j <= height; j++) results[1][j] = 1;

    results[1][1] = 1;
    for (int i = 2; i <= width; i++) {
      for (int j = 1; j <= height; j++) {
        results[i][j] = results[i-1][j] + results[i][j-1];
      }
    }

    return results[width][height];
  }

  private static List<Item> getKnapsackBestValueItems(double[][] resultsTable, Integer[][] backtrack, List<Item> items) {
    int knapsackSize = resultsTable[0].length - 1;
    double currentValue = resultsTable[items.size()][knapsackSize];
    Integer auxCalculationIdx = backtrack[items.size()][knapsackSize];
    List<Item> resultItems = new ArrayList<>();

    for (int i = items.size() - 1; i >= 0; i--) {
      if (auxCalculationIdx == null) break;
      if (currentValue > resultsTable[i][auxCalculationIdx]) resultItems.add(items.get(i));
      currentValue = resultsTable[i][auxCalculationIdx];
      auxCalculationIdx = backtrack[i][auxCalculationIdx];
    }

    return resultItems;
  }
}
