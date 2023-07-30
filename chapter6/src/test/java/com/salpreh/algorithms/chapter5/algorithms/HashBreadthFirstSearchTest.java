package com.salpreh.algorithms.chapter5.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HashBreadthFirstSearchTest {

  private HashBreadthFirstSearch<String> breadthFirstSearch = createBreadthSearch();

  @Test
  void givenGraph_whenSearchNode_shouldReturnPath() {
    // when
    List<String> path = breadthFirstSearch.search("J");

    // then
    assertEquals(Arrays.asList("A", "B", "E", "I", "J"), path);
  }

  @Test
  void givenGraph_whenSearchRootNode_shouldReturnPath() {
    // when
    List<String> path = breadthFirstSearch.search("A");

    // then
    assertEquals(Arrays.asList("A"), path);
  }

  @Test
  void givenGraph_whenSearchNotPresentNode_shouldReturnNull() {
    // when
    List<String> path = breadthFirstSearch.search("Z");

    // then
    assertNull(path);
  }

  private static HashBreadthFirstSearch<String> createBreadthSearch() {
    Map<String, Collection<String>> nodes = new HashMap<>();
    nodes.put("A", List.of("B", "C"));
    nodes.put("B", List.of("D", "E"));
    nodes.put("C", List.of("F"));
    nodes.put("D", List.of());
    nodes.put("E", List.of("H", "I"));
    nodes.put("F", List.of("G"));
    nodes.put("G", List.of());
    nodes.put("H", List.of());
    nodes.put("I", List.of("J"));
    nodes.put("J", List.of());

    return new HashBreadthFirstSearch<>("A", nodes);
  }
}
