package com.salpreh.algorithms.chapter5.algorithms;

import com.salpreh.algorithms.models.Tuple;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class HashBreadthFirstSearch<T> implements BreadthFirstSearch<T> {

  private final T root;
  private final Map<T, Collection<T>> graph;

  public HashBreadthFirstSearch(T root, Map<T, Collection<T>> graph) {
    this.root = root;
    this.graph = graph;
  }

  @Override
  public List<T> search(T item) {
    Queue<Tuple<T, List<T>>> queue = new ArrayDeque<>();
    queue.add(Tuple.of(root, new ArrayList<>()));

    while (!queue.isEmpty()) {
      Tuple<T, List<T>> node = queue.poll();
      if (node.getKey().equals(item)) {
        List<T> path = node.getValue();
        path.add(node.getKey());

        return path;
      } else {
        Collection<T> children = graph.getOrDefault(node.getKey(), List.of());
        List<T> path = addToPath(node.getValue(), node.getKey());
        queue.addAll(packItemsWithPath(children, path));
      }
    }

    return null;
  }

  private List<Tuple<T, List<T>>> packItemsWithPath(Collection<T> item, List<T> path) {
    List<T> pathCopy = new ArrayList<>(path);

    return item.stream()
      .map(i -> Tuple.of(i, pathCopy))
      .collect(Collectors.toList());
  }

  private List<T> addToPath(List<T> path, T newItem) {
    List<T> newPath = new ArrayList<>(path);
    newPath.add(newItem);

    return newPath;
  }
}
