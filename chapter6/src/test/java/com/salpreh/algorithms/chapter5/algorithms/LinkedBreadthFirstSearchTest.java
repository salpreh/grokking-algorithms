package com.salpreh.algorithms.chapter5.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.salpreh.algorithms.models.NLinkedNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LinkedBreadthFirstSearchTest {


  private LinkedBreadthFirstSearch<String> breadthFirstSearch = createBreadthSearch();

  @Test
  void givenGraph_whenSearchNode_shouldReturnPath() {
    // when
    List<String> path = breadthFirstSearch.search("I");

    // then
    assertEquals(Arrays.asList("A", "C", "H", "I"), path);
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

  private static LinkedBreadthFirstSearch<String> createBreadthSearch() {
    var root = new NLinkedNode<>("A");

    var fNode = new NLinkedNode<>("F");
    var eNode = new NLinkedNode<>("E");
    var dNode = new NLinkedNode<>("D", fNode);
    var bNode = new NLinkedNode<>("B", eNode, dNode);

    var iNode = new NLinkedNode<>("I");
    var gNode = new NLinkedNode<>("G");
    var hNode = new NLinkedNode<>("H", iNode);
    var cNode = new NLinkedNode<>("C", gNode, hNode);

    root.getChildren().add(bNode);
    root. getChildren().add(cNode);

    return new LinkedBreadthFirstSearch<>(root);
  }
}
