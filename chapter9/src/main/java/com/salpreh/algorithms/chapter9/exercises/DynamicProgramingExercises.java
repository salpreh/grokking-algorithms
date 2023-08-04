package com.salpreh.algorithms.chapter9.exercises;

import com.salpreh.algorithms.chapter9.models.Item;
import com.salpreh.algorithms.models.Tuple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

  public static boolean canSum(int target, List<Integer> numbers) {
    if (target < 0) return false;
    if (target == 0) return true;

    Boolean[] results = new Boolean[target + 1];

    return canSum(target, numbers, results);
  }

  public static boolean canSum(int target, List<Integer> numbers, Boolean[] results) {
    if (target < 0) return false;
    if (target == 0) return true;

    boolean result = false;
    for (int number: numbers) {
      int newTarget = target - number;
      if (newTarget < 0) continue;

      result = results[newTarget] != null
        ? results[newTarget]
        : canSum(newTarget, numbers, results);

      if (result) break;
    }
    results[target] = result;

    return result;
  }

  public static boolean canSumBottomUp(int target, List<Integer> numbers) {
    if (target < 0) return false;
    if (target == 0) return true;

    boolean[][] results = new boolean[numbers.size()][target+1];

    // Initialize first row
    results[0][0] = true;
    for (int j = 1; j <= target; j++) {
      if (numbers.get(0) > j) results[0][j] = false;
      else results[0][j] = results[0][j - numbers.get(0)];
    }

    for (int i = 1; i < numbers.size(); i++) {
      results[i][0] = true;
      int number = numbers.get(i);
      for (int j = 1; j <= target; j++) {
        if (number > j) results[i][j] = results[i-1][j];
        else results[i][j] = results[i][j - number] || results[i-1][j];
      }

      // short circuit if we already know is possible
      if (results[i][target]) return true;
    }

    return false;
  }

  public static boolean canSumBottomUp2(int target, List<Integer> numbers) {
    if (target < 0) return false;

    boolean[] results = new boolean[target + 1];
    results[0] = true;
    for (int i = 0; i < target; i++) {
      if (!results[i]) continue;
      for(Integer number : numbers) {
        if (i + number <= target) results[i + number] = true;
      }
    }

    return results[target];
  }

  public static List<Integer> howSum(int target, List<Integer> numbers) {
    return howSum(target, numbers, Arrays.asList(new List[target + 1]));
  }

  public static List<Integer> howSum(int target, List<Integer> numbers, List<List<Integer>> results) {
    if (target < 0) return null;
    if (target == 0) return new ArrayList<>();
    if (results.get(target) != null) return results.get(target);

    List<Integer> sumNumbers = null;
    for (int number: numbers) {
      int newTarget = target - number;
      if (newTarget < 0) continue;

      sumNumbers = results.get(newTarget) != null
        ? results.get(newTarget)
        : howSum(newTarget, numbers);

      if (sumNumbers != null) {
        results.set(newTarget, sumNumbers);
        sumNumbers = new ArrayList<>(sumNumbers);
        sumNumbers.add(number);
        break;
      }
    }

    results.set(target, sumNumbers);

    return sumNumbers;
  }

  public static List<Integer> howSumBottomUp(int target, List<Integer> numbers) {
    if (target < 0) return null;

    List<List<Integer>> results = Arrays.asList(new List[target + 1]);
    results.set(0, new ArrayList<>());
//    for (Integer number : numbers) {
//      if (number > target) results.set(number, Collections.singletonList(number));
//    }

    for (int i = 0; i < target; i++) {
      if (results.get(i) == null) continue;
      for (Integer number : numbers) {
        if (i + number <= target) {
          List<Integer> newSum = new ArrayList<>(results.get(i));
          newSum.add(number);
          results.set(i + number, newSum);
        }
      }
    }

    return results.get(target);
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
