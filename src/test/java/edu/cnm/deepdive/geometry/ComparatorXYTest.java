package edu.cnm.deepdive.geometry;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComparatorXYTest {

  static Stream<Arguments> testCompare() {
    return Stream.of(
        Arguments.of(new Point[] {new Point(0, 0), new Point(1, 1), new Point(-2, -2)},
            new Point[] {new Point(-2, -2), new Point(0, 0), new Point(1, 1)}),
        Arguments.of(new Point[] {new Point(0, 0), new Point(0, 1), new Point(0, -2)},
            new Point[] {new Point(0, -2), new Point(0, 0), new Point(0, 1)}),
        Arguments.of(new Point[] {new Point(0, 0), new Point(-1, -1), new Point(0, 0)},
            new Point[] {new Point(-1, -1), new Point(0, 0), new Point(0, 0)})

    );

  }


  @ParameterizedTest(name = "[{index}] input = {0}, expected = {1}")
  @MethodSource
  void testCompare(Point[] input, Point[] expected) {
    List<Point> inputList = new ArrayList<>();
    for (Point p : input) {
      inputList.add(p);
    }

    inputList.sort(new ComparatorXY());

    for (int i = 0; i < inputList.size(); ++i) {
      assertEquals(expected[i], inputList.get(i));
    }
  }

  static Stream<Arguments> testCompareWithStream() {
    return Stream.of(
        Arguments.of(new Point[] {new Point(0, 0), new Point(1, 1), new Point(-2, -2)},
            new Point[] {new Point(-2, -2), new Point(0, 0), new Point(1, 1)}),
        Arguments.of(new Point[] {new Point(0, 0), new Point(0, 1), new Point(0, -2)},
            new Point[] {new Point(0, -2), new Point(0, 0), new Point(0, 1)}),
        Arguments.of(new Point[] {new Point(0, 0), new Point(-1, -1), new Point(0, 0)},
            new Point[] {new Point(-1, -1), new Point(0, 0), new Point(0, 0)})

    );

  }

  @ParameterizedTest(name = "[{index}] input = {0}, expected = {1}")
  @MethodSource
  void testCompareWithStream(Point[] input, Point[] expected) {

    List<Point> sorted = (List<Point>) Arrays.asList(input).stream().sorted(new ComparatorXY());
    assertEquals(expected, sorted);

  }
}
