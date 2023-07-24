package com.salpreh.algorithms.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BiLinkedNode<T> {
  private T data;
  private BiLinkedNode<T> right;
  private BiLinkedNode<T> left;

  public BiLinkedNode(T data, BiLinkedNode<T> right, BiLinkedNode<T> left) {
    this.data = data;
    this.right = right;
    this.left = left;
  }

  public static <T> BiLinkedNode<T> of(T data) {
    return new BiLinkedNode<>(data, null, null);
  }

  public static <T> BiLinkedNode<T> right(T data, BiLinkedNode<T> right) {
    return new BiLinkedNode<>(data, right, null);
  }

  public static <T> BiLinkedNode<T> left(T data, BiLinkedNode<T> left) {
    return new BiLinkedNode<>(data, null, left);
  }

  public boolean hasData() {
    return data != null;
  }

  public boolean hasRight() {
    return right != null;
  }

  public boolean hasLeft() {
    return left != null;
  }
}
