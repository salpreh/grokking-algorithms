package com.salpreh.algorithms.models;

import java.util.Iterator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class LinkedNode<T> implements Iterator<LinkedNode<T>> {
  private T data;
  private LinkedNode<T> next;

  public static <T> LinkedNode<T> of(T data) {
    return new LinkedNode<>(data, null);
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
