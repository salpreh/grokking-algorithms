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
