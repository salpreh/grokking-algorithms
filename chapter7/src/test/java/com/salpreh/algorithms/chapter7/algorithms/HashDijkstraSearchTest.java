package com.salpreh.algorithms.chapter7.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.salpreh.algorithms.models.Edge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HashDijkstraSearchTest {

  private HashDijkstraSearch<String> dijkstraSearch = createDijkstraSearch();

  @Test
  void givenGraph_whenSearchNode_shouldFindShortestPath() {
    // when
    List<String> result = dijkstraSearch.search("D");

    // then
    assertEquals(List.of("A", "C", "D"), result);
  }

  @Test
  void givenGraph_whenSearchSinkNode_shouldFindShortestPath() {
    // when
    List<String> result = dijkstraSearch.search("E");

    // then
    assertEquals(List.of("A", "C", "D", "E"), result);
  }

  @Test
  void givenGraph_whenSearchRootNode_shouldFindPath() {
    // when
    List<String> result = dijkstraSearch.search("A");

    // then
    assertEquals(List.of("A"), result);
  }

  @Test
  void givenGraph_whenSearchNonExistentNode_shouldReturnNull() {
    // when
    List<String> result = dijkstraSearch.search("Z");

    // then
    assertNull(result);
  }

  private HashDijkstraSearch<String> createDijkstraSearch() {
    Map<String, List<Edge<String, Double>>> graph = new HashMap<>();
    graph.put("A", List.of(new Edge<>("B", 1.0), new Edge<>("C", 3.0)));
    graph.put("B", List.of(new Edge<>("D", 4.0)));
    graph.put("C", List.of(new Edge<>("D", 1.0), new Edge<>("E", 6.0)));
    graph.put("D", List.of(new Edge<>("E", 3.0)));
    graph.put("E", null);

    return new HashDijkstraSearch<>("A", graph);
  }
}
