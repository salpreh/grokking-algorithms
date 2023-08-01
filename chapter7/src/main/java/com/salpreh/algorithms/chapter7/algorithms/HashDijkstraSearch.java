package com.salpreh.algorithms.chapter7.algorithms;

import com.salpreh.algorithms.algorithms.SearchAlgorithm;
import com.salpreh.algorithms.models.Edge;
import com.salpreh.algorithms.models.Tuple;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashDijkstraSearch<I> implements SearchAlgorithm<I, List<I>> {

  private final I root;
  private final Map<I, List<Edge<I, Double>>> graph;

  public HashDijkstraSearch(I root, Map<I, List<Edge<I, Double>>> graph) {
    this.root = root;
    this.graph = graph;
  }

  @Override
  public List<I> search(I item) {
    Map<I, Tuple<Double, I>> resultTable = new HashMap<>();
    Set<I> exploredNodes = new HashSet<>();

    resultTable.put(root, Tuple.of(0D, null));
    I nextMinNode;

    do {
      nextMinNode = getNextMinNode(resultTable, exploredNodes);
      updateResultsTable(nextMinNode, graph.get(nextMinNode), resultTable);
      exploredNodes.add(nextMinNode);

    } while (nextMinNode != null);

    return getPathFromResult(item, resultTable);
  }

  private I getNextMinNode(Map<I, Tuple<Double, I>> resultTable, Set<I> exploredNodes) {
    return resultTable.entrySet().stream()
      .filter(e -> !exploredNodes.contains(e.getKey()))
      .min(Comparator.comparing(e -> e.getValue().first()))
      .map(Entry::getKey)
      .orElse(null);
  }

  private void updateResultsTable(I srcNode, Collection<Edge<I, Double>> edges, Map<I, Tuple<Double, I>> resultsTable) {
    if (edges == null || edges.isEmpty()) return;

    double baseValue = resultsTable.getOrDefault(srcNode, Tuple.of(0D, null)).first();
    edges.forEach(edge -> {
      double currentValue = resultsTable.getOrDefault(edge.node(), Tuple.of(Double.POSITIVE_INFINITY, null)).first();
      double newValue = baseValue + edge.weight();
      if (newValue < currentValue) {
        resultsTable.put(edge.node(), Tuple.of(newValue, srcNode));
      }
    });
  }

  private List<I> getPathFromResult(I node, Map<I, Tuple<Double, I>> resultsTable) {
    if (!resultsTable.containsKey(node)) return null;

    return getPathFromResult(node, resultsTable, new ArrayList<>());
  }

  private List<I> getPathFromResult(I node, Map<I, Tuple<Double, I>> resultsTable, List<I> path) {
    I parentNode = resultsTable.getOrDefault(node, Tuple.of(0D, null)).second();
    if (parentNode != null) path = getPathFromResult(parentNode, resultsTable, path);
    path.add(node);

    return path;
  }
}
