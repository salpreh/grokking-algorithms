package com.salpreh.algorithms.models;

import java.util.Iterator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedNode<T> implements Iterable<LinkedNode<T>> {
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
  public Iterator<LinkedNode<T>> iterator() {
    return new LinkedNodeIterator(this);
  }

  protected class LinkedNodeIterator implements Iterator<LinkedNode<T>> {
    private LinkedNode<T> current;

    protected LinkedNodeIterator(LinkedNode<T> root) {
      this.current = root;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public LinkedNode<T> next() {
      LinkedNode<T> item = current;
      current = current.getNext();

      return item;
    }
  }
}
