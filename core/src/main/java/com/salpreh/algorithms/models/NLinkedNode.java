package com.salpreh.algorithms.models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NLinkedNode<T> implements Iterable<NLinkedNode<T>> {
  private T data;
  private Collection<NLinkedNode<T>> children;

  public NLinkedNode(T data, NLinkedNode<T> child) {
    this.data = data;
    this.children = new ArrayList<>();
    children.add(child);
  }

  public NLinkedNode(T data, Collection<NLinkedNode<T>> children) {
    this.data = data;
    this.children = children;
  }

  public static <T> LinkedNode<T> of(T data) {
    return new LinkedNode<T>(data, null);
  }

  @Override
  public Iterator<NLinkedNode<T>> iterator() {
    return new NLinkedNodeBredathIterator(this);
  }

  private class NLinkedNodeBredathIterator implements Iterator<NLinkedNode<T>> {

    private Queue<NLinkedNode<T>> queue = new ArrayDeque<>();

    protected NLinkedNodeBredathIterator(NLinkedNode<T> root) {
      queue.add(root);
    }

    @Override
    public boolean hasNext() {
      return !queue.isEmpty();
    }

    @Override
    public NLinkedNode<T> next() {
      NLinkedNode<T> currentNode = queue.remove();
      queue.addAll(currentNode.getChildren());

      return currentNode;
    }
  }
}
