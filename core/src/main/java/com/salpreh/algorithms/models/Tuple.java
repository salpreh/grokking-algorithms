package com.salpreh.algorithms.models;


public record Tuple<F, S>(F first, S second) {
  public static <F, S> Tuple<F, S> of(F first, S second) {
    return new Tuple<>(first, second);
  }

  public F getKey() {
    return first;
  }

  public S getValue() {
    return second;
  }
}
