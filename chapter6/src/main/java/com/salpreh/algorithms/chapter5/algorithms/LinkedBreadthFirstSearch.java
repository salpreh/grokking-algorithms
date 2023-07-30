package com.salpreh.algorithms.chapter5.algorithms;

import com.salpreh.algorithms.models.NLinkedNode;
import com.salpreh.algorithms.models.Tuple;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedBreadthFirstSearch<T> implements BreadthFirstSearch<T> {

  private NLinkedNode<T> root;

  public LinkedBreadthFirstSearch(NLinkedNode<T> root) {
    this.root = root;
  }

  @Override
  public List<T> search(T item) {
    return search(item, List.of(Tuple.of(root, new ArrayList<>())));
  }

  private List<T> search(T item, Collection<Tuple<NLinkedNode<T>, List<T>>> collection) {
    if (collection == null || collection.isEmpty()) return null;

    Collection<Tuple<NLinkedNode<T>, List<T>>> children = new ArrayList<>();
    for (Tuple<NLinkedNode<T>, List<T>> current : collection) {
      NLinkedNode<T> node = current.first();
      List<T> path = current.second();

      if (node.getData().equals(item)) {
        path.add(node.getData());
        return path;
      }

      children.addAll(packChildrenWithPath(node, path));
    }

    return search(item, children);
  }

  private Collection<Tuple<NLinkedNode<T>, List<T>>> packChildrenWithPath(NLinkedNode<T> node, List<T> path) {
    List<T> newPath = new ArrayList<>(path);
    newPath.add(node.getData());

    return node.getChildren().stream()
      .map(n -> Tuple.of(n, newPath))
      .collect(Collectors.toList());
  }
}
