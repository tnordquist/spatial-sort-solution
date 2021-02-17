package edu.cnm.deepdive.geometry;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComparatorMagnitudeTest {

  static Stream<Arguments> testCompare() {
    return Stream.of(
        Arguments.of(new Point[] {new Point(-2, -2), new Point(0, 0), new Point(1, 1)},
            new Point[] {new Point(0, 0), new Point(1, 1), new Point(-2, -2)}),
        Arguments.of(new Point[] {new Point(0, -2), new Point(0, 0), new Point(0, 1)},
            new Point[] {new Point(0, 0), new Point(0, 1), new Point(0, -2)}),
        Arguments.of(new Point[] {new Point(-1, -1), new Point(0, 0), new Point(0, 0)},
            new Point[] {new Point(0, 0), new Point(0, 0), new Point(-1, -1)})

    );

  }

  @ParameterizedTest(name = "[{index}] input = {0}, expected = {1}")
  @MethodSource
  void testCompare(Point[] input, Point[] expected) {
    List<Point> inputList = new ArrayList<>();
    for (Point p : input) {
      inputList.add(p);
    }

    inputList.sort(new ComparatorMagnitude());

    for (int i = 0; i < inputList.size(); ++i) {
      assertEquals(expected[i], inputList.get(i));
    }
  }

}
