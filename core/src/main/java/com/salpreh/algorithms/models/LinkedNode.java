package com.salpreh.algorithms.models;

import java.util.Iterator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedNode<T> implements Iterator<LinkedNode<T>> {
  private T data;
  private LinkedNode<T> next;

  public LinkedNode(T data, LinkedNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public static <T> LinkedNode<T> of(T data) {
    return new LinkedNode<T>(data, null);
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }

  @Override
  public LinkedNode<T> next() {
    return next;
  }
}
