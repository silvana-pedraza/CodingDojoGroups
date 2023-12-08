package com.codingdojo.groups;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GroupsTest extends TestCase {
  public GroupsTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(GroupsTest.class);
  }

  public void test1() {
    Groups groups = new Groups();
    List<List<Integer>> result = groups.groupThePeople(new int[] {3, 3, 3, 3, 3, 1, 3});
    assertEquals(1, getNumberOfListsOfSizeN(result, 1));
    assertTrue(List.of(5).containsAll(getElementsOfListOfSizeN(result, 1)));
    assertEquals(2, getNumberOfListsOfSizeN(result, 3));
    assertTrue(List.of(0, 1, 2, 3, 4, 6).containsAll(getElementsOfListOfSizeN(result, 3)));
  }

  public void test2() {
    Groups groups = new Groups();
    List<List<Integer>> result = groups.groupThePeople(new int[] {2, 1, 3, 3, 3, 2});
    assertEquals(3, result.size());
    assertEquals(1, getNumberOfListsOfSizeN(result, 1));
    assertTrue(List.of(1).containsAll(getElementsOfListOfSizeN(result, 1)));
    assertEquals(1, getNumberOfListsOfSizeN(result, 2));
    assertTrue(List.of(0, 5).containsAll(getElementsOfListOfSizeN(result, 2)));
    assertEquals(1, getNumberOfListsOfSizeN(result, 3));
    assertTrue(List.of(2, 3, 4).containsAll(getElementsOfListOfSizeN(result, 3)));
  }

  public void test3() {
    Groups groups = new Groups();
    List<List<Integer>> result =
        groups.groupThePeople(new int[] {2, 1, 3, 4, 4, 3, 2, 3, 4, 2, 2, 4});
    assertEquals(5, result.size());
    assertEquals(1, getNumberOfListsOfSizeN(result, 1));
    assertTrue(List.of(1).containsAll(getElementsOfListOfSizeN(result, 1)));
    assertEquals(2, getNumberOfListsOfSizeN(result, 2));
    assertTrue(List.of(0, 6, 9, 10).containsAll(getElementsOfListOfSizeN(result, 2)));
    assertEquals(1, getNumberOfListsOfSizeN(result, 3));
    assertTrue(List.of(2, 5, 7).containsAll(getElementsOfListOfSizeN(result, 3)));
    assertEquals(1, getNumberOfListsOfSizeN(result, 4));
    assertTrue(List.of(3, 4, 8, 11).containsAll(getElementsOfListOfSizeN(result, 4)));
  }

  public void test4() {
    Groups groups = new Groups();
    List<List<Integer>> result = groups.groupThePeople(new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5});
    assertEquals(2, result.size());
    assertEquals(2, getNumberOfListsOfSizeN(result, 5));
    assertTrue(
        List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).containsAll(getElementsOfListOfSizeN(result, 5)));
  }

  public List<Integer> getElementsOfListOfSizeN(List<List<Integer>> lists, int n) {
    List<Integer> result = new ArrayList<>();
    for (List<Integer> list : lists) {
      if (list.size() == n) {
        result.addAll(list.subList(0, n));
      }
    }
    return result;
  }

  public int getNumberOfListsOfSizeN(List<List<Integer>> lists, int n) {
    int count = 0;
    for (List<Integer> list : lists) {
      if (list.size() == n) {
        count++;
      }
    }
    return count;
  }
}
